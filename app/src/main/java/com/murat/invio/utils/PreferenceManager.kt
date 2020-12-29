package com.murat.invio.utils

import android.annotation.SuppressLint
import android.content.Context
import com.murat.invio.ext.get
import com.murat.invio.ext.set

class PreferenceManager(context: Context) {
    companion object {
        private const val PREFS = "prefs"

    }
    private val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)

//
//    /**
//     * ClientId
//     */
//    var clientId: String?
//        get() = prefs.get(CLIENT_ID)
//        set(value) {
//             prefs.set(CLIENT_ID, value)
//        }

}