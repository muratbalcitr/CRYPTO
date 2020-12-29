package com.murat.invio.ui.main

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import com.murat.invio.R
import com.murat.invio.core.BaseActivity
import com.murat.invio.databinding.ActivityMainBinding


class MainActivity :
    BaseActivity<ActivityMainBinding, MainActivityViewModel>(R.layout.activity_main) {

    override fun viewModelClass() = MainActivityViewModel::class

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            MainActivity::class.java
        )
    }

}
