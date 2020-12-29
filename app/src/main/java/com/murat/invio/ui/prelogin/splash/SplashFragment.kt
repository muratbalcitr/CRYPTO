package com.murat.invio.ui.prelogin.splash

import android.annotation.SuppressLint
import android.os.Build
import android.provider.Settings
import androidx.navigation.fragment.findNavController
import com.murat.invio.R
import com.murat.invio.core.BaseFragment
import com.murat.invio.databinding.FragmentSplashBinding
import com.murat.invio.ext.observeEvent
import com.murat.invio.ui.main.MainActivity
import java.text.DateFormat
import java.util.*

class SplashFragment : BaseFragment<FragmentSplashBinding, SplashViewModel>(
    layoutId = R.layout.fragment_splash
) {
    override fun viewModelClass() = SplashViewModel::class

    @SuppressLint("HardwareIds")
    override fun onInitDataBinding() {
        //viewModel.prefManager.onboarding = false

        viewBinding.viewModel = viewModel
        observeEvent(viewModel.event, ::onViewEvent)


            viewModel.continueProcess()
    }


    private fun onViewEvent(event: SplashViewEvent) {
        when (event) {
            SplashViewEvent.NavigateToWelcome -> {
                findNavController().navigate(R.id.action_splash_to_welcome)
            }

            SplashViewEvent.NavigateToMain -> {
                 startActivity(MainActivity.newIntent(requireContext())).apply { requireActivity().finish() }
            }

            SplashViewEvent.NetworkError -> showCommonError()

        }
    }
}
