package com.murat.invio.ui.main

import android.annotation.SuppressLint
import android.os.Handler
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.murat.invio.core.BaseListAdapter
import com.murat.invio.core.BaseViewHolder
import com.murat.invio.databinding.ItemLoadingBinding
import com.murat.invio.databinding.ViewHolderCoinItemBinding
import com.murat.invio.network.responses.CoinsResponse

class MainAdapter(
    private var coinList: ArrayList<CoinsResponse.Data.Coins?>?,
    val viewModel: MainViewModel
) : BaseListAdapter<CoinsResponse.Data.Coins>(
    itemsSame = { old, new -> old == new },
    contentsSame = { old, new -> old == new }
) {
    private val VIEW_TYPE_ITEM = 0
    private val VIEW_TYPE_LOADING = 1

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ITEM) {
            CoinViewHolder(parent, inflater)
        } else {
            LoadingViewHolder(parent, inflater)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (coinList?.get(position) == null) {
            VIEW_TYPE_LOADING
        } else {
            VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CoinViewHolder -> {
                holder.bind(viewModel, coinList?.get(position)!!)
            }
            is LoadingViewHolder -> {
                var holder: LoadingViewHolder = holder
            }
        }
    }


    override fun getItemCount(): Int {
        return if (coinList == null) 0 else coinList?.size!!
    }

    fun addData(dataViews: ArrayList<CoinsResponse.Data.Coins?>?) {
        if (dataViews != null) {
            coinList?.addAll(dataViews)
        }
        notifyDataSetChanged()
    }

    fun addLoadingView() {
        Handler().post {
            coinList?.add(null)
            notifyItemInserted(coinList?.size!! - 1)
        }
    }

    fun removeLoadingView() {
        coinList?.removeAt(coinList!!.size - 1)
        coinList?.size?.minus(1)?.let { notifyItemRemoved(it) }

    }

    fun getItemAtPosition(position: Int): CoinsResponse.Data.Coins? {
        return coinList?.get(position)
    }

    class CoinViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater
    ) : BaseViewHolder<ViewHolderCoinItemBinding>(
        binding = ViewHolderCoinItemBinding.inflate(inflater, parent, false)
    ) {
        @SuppressLint("SimpleDateFormat")
        fun bind(
            viewModel: MainViewModel,
            coinResponse: CoinsResponse.Data.Coins
        ) {
            binding.viewModel = viewModel
            binding.item = coinResponse
            binding.executePendingBindings()
        }
    }

    private class LoadingViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater
    ) : BaseViewHolder<ItemLoadingBinding>(
        binding = ItemLoadingBinding.inflate(inflater, parent, false)
    )
}

