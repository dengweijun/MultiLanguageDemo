package com.ben.multilanguagedemo

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
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