package com.dokidevs.demo

import android.os.Build
import android.util.Log
import com.dokidevs.dokilog.LogProfile

class ReleaseLogProfile: LogProfile("Release") {

    init {
        // Give it a new filter tag
        filterTag = "Release"
    }

    // Modify VERBOSE level to ERROR level
    override fun adjustPriority(priority: Int): Int {
        if (priority == Log.VERBOSE) {
            return Log.ERROR
        }
        return priority
    }

    // Only log for ERROR and ASSERT
    override fun isLoggable(priority: Int): Boolean {
        return priority == Log.ERROR || priority == Log.ASSERT
    }

    // Use the parent class name instead of subclass name in default profile
    override fun getTag(className: String, stackTraceElement: StackTraceElement): String {
        val tag = "$filterTag - ${stackTraceElement.className} | ${stackTraceElement.methodName}"
        if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return tag
        }
        return tag.substring(0, MAX_TAG_LENGTH)
    }

}