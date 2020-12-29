package com.murat.invio.ui.main.coin_detail

import android.content.Context
import android.content.Intent
import android.text.Html
import com.murat.invio.R
import com.murat.invio.core.BaseActivity
import com.murat.invio.databinding.ActivityCoinDetailBinding
import com.murat.invio.ext.observe
import com.murat.invio.ext.observeEvent
import com.murat.invio.network.responses.CoinsDetailResponse


class CoinDetailActivity :
    BaseActivity<ActivityCoinDetailBinding, CoinDetailViewModel>(R.layout.activity_coin_detail) {


    override fun viewModelClass() = CoinDetailViewModel::class

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
        observeEvent(viewModel.event, ::onViewEvent)
         intent.getStringExtra(UUID)?.let { viewModel.getDetailsCoins(it) }
        observe(viewModel.coinDetail,::onDataChange)
    }

    private fun onDataChange(item:CoinsDetailResponse){
        viewBinding.descriptionTextView.setText(Html.fromHtml(item.data.coins.description))
    }
    private fun onViewEvent(event: CoinDetailViewEvent) {
        when (event) {

        }
    }


    companion object {
        const val UUID = "uuid"
        fun newIntent(context: Context, uuid: String): Intent = Intent(
            context,
            CoinDetailActivity::class.java
        ).apply {
            putExtra(UUID, uuid)
        }
    }

}
