package com.ben.multilanguagedemo

import android.app.Application
import android.content.res.Configuration
import java.util.*

/**
 *
 * @author: BD
 */
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setLanguage()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        setLanguage()
    }

    private fun setLanguage() {
        if (BuildConfig.LANGUAGE == "ENGLISH") {
            Utils.setAppLanguage(this, Locale.ENGLISH)
        } else {
            Utils.setAppLanguage(this, Locale.CHINA)
        }
    }
}