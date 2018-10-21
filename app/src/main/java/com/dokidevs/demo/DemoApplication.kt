package com.dokidevs.demo

import android.app.Application
import com.dokidevs.dokilog.DokiLog
import com.dokidevs.dokilog.LogProfile

class DemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        // Add a log profile for debugging
        if (BuildConfig.DEBUG) {
            // Use the default log profile and give it a name, this should be sufficient for most use cases.
            DokiLog.addProfile(LogProfile("Debug"))
            // For demo purpose, adding multiple profiles
            DokiLog.addProfile(ReleaseLogProfile())
        } else {
            // Create a custom profile for release
            DokiLog.addProfile(ReleaseLogProfile())
        }
    }

}