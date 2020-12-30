package com.murat.invio.ui.prelogin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.annotation.NavigationRes
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.murat.invio.R
import com.murat.invio.core.BaseActivity
import com.murat.invio.databinding.ActivityPreloginBinding
import com.murat.invio.ui.main.MainActivity
import kotlinx.android.synthetic.main.activity_prelogin.*

class PreLoginActivity :
    BaseActivity<ActivityPreloginBinding, PreLoginViewModel>(
        R.layout.activity_prelogin
    ),
    NavController.OnDestinationChangedListener {

    override fun viewModelClass() = PreLoginViewModel::class

    @NavigationRes
    private val navigationGraph: Int = R.navigation.navigation_prelogin_graph

    private lateinit var navController: NavController
    private var currentDestination = PreLoginDestination.SPLASH
    private lateinit var navGraph: NavGraph
    override fun onInitDataBinding() {
        isMoov = intent.getBooleanExtra(HOW_MOOV, false)
        isMoovWelcome = intent.getBooleanExtra(HOW_MOOV_WELCOME, false)
        setNavigation()
    }

    private fun setNavigation() {
        val navHostFragment = prelogin_nav_host_fragment as NavHostFragment
        val graphInflater = navHostFragment.navController.navInflater
        navGraph = graphInflater.inflate(navigationGraph)
        navController = navHostFragment.navController
        navController.addOnDestinationChangedListener(this)
        navGraph.startDestination = PreLoginDestination.getAction(currentDestination)
        navController.graph = navGraph
    }

    private fun setCurrentDestination(destination: PreLoginDestination) {
        this.currentDestination = destination
    }

    fun navigateToMainActivity() {

        startActivity(MainActivity.newIntent(this)).also { finishAffinity() }
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out)

    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        setCurrentDestination(PreLoginDestination.find(destination.id))
    }

    override fun onBackPressed() {

        super.onBackPressed()

    }
}
