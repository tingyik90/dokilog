@file:Suppress("NOTHING_TO_INLINE")

package com.dokidevs.dokilog

import android.util.Log

/**
 * Main interface for DokiLog. See [LogProfile] to customize logging.
 */
interface DokiLog {

    /* companion object */
    companion object {

        private val mutableLogProfiles = mutableListOf<LogProfile>()
        private var logProfiles = arrayOf<LogProfile>()

        /**
         * Add a log profile. This is similar to planting a tree in Timber (by Jake Wharton).
         * The profile name must be unique. Newly added profile will overwrite the old profile with the same name.
         * @param logProfile Customizable [LogProfile] which is identified by its name.
         */
        fun addProfile(logProfile: LogProfile) {
            synchronized(mutableLogProfiles) {
                if (mutableLogProfiles.contains(logProfile)) {
                    mutableLogProfiles.remove(logProfile)
                }
                mutableLogProfiles.add(logProfile)
                logProfiles = mutableLogProfiles.toTypedArray()
            }
        }

        /**
         * Remove a log profile. This is similar to uprooting a tree in Timber (by Jake Wharton).
         * @param logProfile Customizable [LogProfile] which is identified by its name.
         */
        fun removeProfile(logProfile: LogProfile) {
            synchronized(mutableLogProfiles) {
                mutableLogProfiles.remove(logProfile)
                logProfiles = mutableLogProfiles.toTypedArray()
            }
        }

        /**
         * Remove all log profiles.
         */
        fun clearAllProfiles() {
            synchronized(mutableLogProfiles) {
                mutableLogProfiles.clear()
                logProfiles = arrayOf()
            }
        }

        /**
         * Check if log profiles are present before dispatching the log.
         * @return true if [logProfiles] is not empty.
         */
        fun hasLogProfiles(): Boolean {
            synchronized(logProfiles) {
                return logProfiles.isNotEmpty()
            }
        }

        /**
         * Actual execution method to loop through all log profiles. Entry point to [LogProfile.prepareLog].
         * You usually will not call this method directly.
         */
        fun log(priority: Int, className: String, message: String? = null, t: Throwable? = null) {
            val _logProfiles = logProfiles
            for (logProfile in _logProfiles) {
                logProfile.prepareLog(priority, t, message, className)
            }
        }

    }

    /**
     * Enable log for the class which DokiLog interface is attached to.
     * Override this to enable or disable log for the class.
     */
    val enableClassLog: Boolean
        get() = true

    /**
     * Class name which DokiLog interface is attached to.
     * This will show the subclass even if DokiLog is implemented in the parent class.
     * To show the parent class name instead, get them from the [StackTraceElement.getClassName] in [LogProfile.getTag].
     */
    val className: String
        get() = javaClass.simpleName

}

/**
 * Log at [Log.VERBOSE] level.
 *
 * @param message Message. Default = null
 * @param t Throwable. Default = null
 */
inline fun DokiLog.v(message: String? = null, t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.VERBOSE, className, message, t)
}

/**
 * Log at [Log.VERBOSE] level.
 *
 * @param t Throwable. Default = null
 */
inline fun DokiLog.v(t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.VERBOSE, className, null, t)
}

/**
 * Log at [Log.DEBUG] level.
 *
 * @param message Message. Default = null
 * @param t Throwable. Default = null
 */
inline fun DokiLog.d(message: String? = null, t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.DEBUG, className, message, t)
}

/**
 * Log at [Log.DEBUG] level.
 *
 * @param t Throwable. Default = null
 */
inline fun DokiLog.d(t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.DEBUG, className, null, t)
}

/**
 * Log at [Log.WARN] level.
 *
 * @param message Message. Default = null
 * @param t Throwable. Default = null
 */
inline fun DokiLog.w(message: String? = null, t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.WARN, className, message, t)
}

/**
 * Log at [Log.WARN] level.
 *
 * @param t Throwable. Default = null
 */
inline fun DokiLog.w(t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.WARN, className, null, t)
}

/**
 * Log at [Log.ERROR] level.
 *
 * @param message Message. Default = null
 * @param t Throwable. Default = null
 */
inline fun DokiLog.e(message: String? = null, t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.ERROR, className, message, t)
}

/**
 * Log at [Log.ERROR] level.
 *
 * @param t Throwable. Default = null
 */
inline fun DokiLog.e(t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.ERROR, className, null, t)
}

/**
 * Log at [Log.ASSERT] level.
 *
 * @param message Message. Default = null
 * @param t Throwable. Default = null
 */
inline fun DokiLog.wtf(message: String? = null, t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.ASSERT, className, message, t)
}

/**
 * Log at [Log.ASSERT] level.
 *
 * @param t Throwable. Default = null
 */
inline fun DokiLog.wtf(t: Throwable? = null) {
    if (enableClassLog && DokiLog.hasLogProfiles()) DokiLog.log(Log.ASSERT, className, null, t)
}