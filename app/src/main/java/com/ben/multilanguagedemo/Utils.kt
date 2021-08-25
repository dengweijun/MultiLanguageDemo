package com.ben.multilanguagedemo

import android.content.Context
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import android.util.DisplayMetrics
import java.util.*

/**
 *
 * @author: BD
 */
object Utils {
    /**
     * 更新应用语言（核心）
     * @param context
     * @param locale
     */
    fun setAppLanguage(context: Context, locale: Locale) {
        val resources: Resources = context.resources
        val metrics: DisplayMetrics = resources.displayMetrics
        val configuration: Configuration = resources.configuration
        //Android 7.0以上的方法
        if (Build.VERSION.SDK_INT >= 24) {
            configuration.setLocale(locale)
            configuration.setLocales(LocaleList(locale))
            context.createConfigurationContext(configuration)
            //实测，updateConfiguration这个方法虽然很多博主说是版本不适用
            //但是我的生产环境androidX+Android Q环境下，必须加上这一句，才可以通过重启App来切换语言
            resources.updateConfiguration(configuration, metrics)
        } else {
            //Android 7.0 以下方法
            configuration.setLocale(locale)
            resources.updateConfiguration(configuration, metrics)
        }
    }
}