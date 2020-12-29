package com.murat.invio.ui.prelogin.welcome

import com.murat.invio.ui.prelogin.PreLoginActivity
import com.murat.invio.R
import com.murat.invio.core.BaseFragment
import com.murat.invio.databinding.FragmentWelcomeBinding
import com.murat.invio.ext.observeEvent

/**
 * @user: omer.karaca
 * @date: 2020-01-19
 */

class WelcomeFragment : BaseFragment<FragmentWelcomeBinding, WelcomeViewModel>(
    layoutId = R.layout.fragment_welcome
) {
    override fun viewModelClass() = WelcomeViewModel::class

    override fun onInitDataBinding() {
        viewBinding.viewModel = viewModel
        observeEvent(viewModel.event, ::onViewEvent)
/*
            viewBinding.lottieWelcome.apply {
                setAnimation(getString(R.string.onbooarding_lottie_notification_permission_json))
                playAnimation()
                loop(true)
                repeatCount = LottieDrawable.INFINITE
            }
            */
    }

    private fun onViewEvent(event: WelcomeViewEvent) {
        (activity as? PreLoginActivity)?.let {
            when (event) {
                WelcomeViewEvent.NavigateToMain -> it.navigateToMainActivity()
            }
        }
    }
}
