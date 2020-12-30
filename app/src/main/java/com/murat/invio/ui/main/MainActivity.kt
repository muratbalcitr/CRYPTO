package com.murat.invio.ui.main

import android.content.Context
import android.content.Intent
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import com.murat.invio.R
import com.murat.invio.core.BaseActivity
import com.murat.invio.databinding.ActivityMainBinding
import com.murat.invio.ext.observe
import com.murat.invio.ext.observeEvent
import com.murat.invio.network.responses.CoinsResponse
import com.murat.invio.ui.main.coin_detail.CoinDetailActivity
import com.murat.invio.utils.OnLoadMoreListener
import com.murat.invio.utils.RecyclerViewLoadMoreScroll


class MainActivity :
    BaseActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    lateinit var mainAdapter: MainAdapter
    private lateinit var layoutManager: LinearLayoutManager
    private var scrollListener: RecyclerViewLoadMoreScroll? = null

    override fun viewModelClass() = MainViewModel::class

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
        observeEvent(viewModel.event, ::onViewEvent)
        observe(viewModel.coins, ::onDataChange)
        setup()

        viewModel.getCoins(viewModel.offset.value!!)
    }

    private fun setup() {
        layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        scrollListener = RecyclerViewLoadMoreScroll(layoutManager)
        viewBinding.recyclerView.addOnScrollListener(scrollListener!!)
        scrollListener?.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore() {
                loadMore()
            }
        })
    }

    private fun onViewEvent(event: MainViewEvent) {
        when (event) {
            is MainViewEvent.NavigateToDetail -> {
                startActivity(event.item.uuid?.let { CoinDetailActivity.newIntent(this, it) })
            }
        }
    }

    private fun onDataChange(item: CoinsResponse) {
        if (viewModel.offset.value == 1) {
            mainAdapter = MainAdapter(item.data.coins, viewModel, this)
            viewBinding.recyclerView.apply {
                this.setHasFixedSize(true)
                this.adapter = mainAdapter
                this.layoutManager = layoutManager
            }
        } else {
            mainAdapter.removeLoadingView()
            scrollListener!!.setLoaded()
            mainAdapter.notifyDataSetChanged()
            viewModel.isLoadingMore.postValue(false)
            mainAdapter.addData(item.data.coins)

        }
    }

    fun loadMore() {
        if (viewModel.isLoadingMore.value == true) {
            mainAdapter.removeLoadingView()
            scrollListener!!.setLoaded()
            mainAdapter.notifyDataSetChanged()
            viewModel.isLoadingMore.postValue(false)
        } else {
            viewModel.isLoadingMore.postValue(true)
            mainAdapter.addLoadingView()
            var offset = viewModel.offset.value ?: 1
            offset += 1
            viewModel.offset.postValue(offset)
            Handler().postDelayed({
                viewModel.getCoins(offset)

            }, 2000)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            MainActivity::class.java
        )
    }

}
