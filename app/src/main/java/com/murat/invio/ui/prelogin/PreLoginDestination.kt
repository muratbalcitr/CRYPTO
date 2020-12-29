package com.murat.invio.ui.prelogin

import androidx.annotation.NavigationRes
import com.murat.invio.R

/**
 * @user: omer.karaca
 * @date: 2020-02-24
 */

enum class PreLoginDestination {
    SPLASH, WELCOME;

    companion object {
        fun find(@NavigationRes id: Int): PreLoginDestination = when (id) {
            R.id.splash -> SPLASH
            R.id.welcome -> WELCOME
            else -> throw Exception("Unkown  Destination")
        }

        fun getAction(destination: PreLoginDestination): Int = when (destination) {
            SPLASH -> R.id.splash
            WELCOME -> R.id.welcome
        }
    }
}
