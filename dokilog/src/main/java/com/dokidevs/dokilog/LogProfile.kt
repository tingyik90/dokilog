package com.dokidevs.dokilog

import android.os.Build
import android.util.Log
import java.io.PrintWriter
import java.io.StringWriter

/**
 * Log profile which can be extended to customise log format.
 *
 * @param profileName Unique name for the profile. See [DokiLog.addProfile].
 */
open class LogProfile(protected val profileName: String) {

    /* companion object */
    companion object {

        // Max tag characters length limitation for API <= 23.
        const val MAX_TAG_LENGTH = 23
        // Maximum character limitation per line for the log.
        const val MAX_LOG_LENGTH = 4000

    }

    /**
     * Index for the StackTraceElement in [getStackTraceElement]. This is dependent on your code. For this library, [callStackIndex] = 3.
     * Do not override this unless you are overriding other methods and the StackTraceElement returned is incorrect.
     */
    protected var callStackIndex = 3
    /**
     * Custom tag used for filtering when going through logcat. Default = "Doki".
     * By default, this is included in [getTag] as part of the tag.
     */
    protected var filterTag = "Doki"

    /**
     * Entry point to the whole logging process. Prepare log based on message and throwable.
     * If both are null, the message is set as "called", so that no message is swallowed.
     * This is useful for checking the method calls sequence.
     * For example, simply call v(), d(), etc. anywhere and it will return "methodName: called".
     *
     * @param t Throwable.
     * @param message Message.
     *
     * @see [adjustPriority], [isLoggable], [getTag], [getStackTraceElement].
     */
    open fun prepareLog(priority: Int, t: Throwable? = null, message: String?, className: String) {
        val newPriority = adjustPriority(priority)
        if (isLoggable(newPriority)) {
            var log = message
            if (log != null) {
                // Attach stack trace below the message if available
                if (t != null) {
                    log += "\n" + getStackTraceString(t)
                }
            } else if (t != null) {
                // Print stack trace directly if no message
                log = getStackTraceString(t)
            } else {
                // Replace with "called" if both are null
                log = "called"
            }
            log(newPriority, getTag(className, getStackTraceElement()), log)
        }
    }

    /**
     * Get defined tag for the log. Default has the format of
     * "$filterTag - $className | ${stackTraceElement.methodName}"
     *
     * @param stackTraceElement StackTraceElement returned from [getStackTraceElement].
     */
    protected open fun getTag(className: String, stackTraceElement: StackTraceElement): String {
        val tag = "$filterTag - $className | ${stackTraceElement.methodName}"
        if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return tag
        }
        return tag.substring(0, MAX_TAG_LENGTH)
    }

    /**
     * Adjust the priority for certain conditions. By default, there is no adjustment.
     * Source code shows how to change the priority based on device manufacturer.
     *
     * @param priority Priority of the current log.
     * @return The adjusted priority.
     */
    protected open fun adjustPriority(priority: Int): Int {
        /*
        if (Build.MANUFACTURER.equals("huawei", true) ||
            Build.MANUFACTURER.equals("samsung", true)
        ) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return Log.INFO
            }
        }
        */
        return priority
    }

    /**
     * Sets the condition to log based on priority. Default = true.
     *
     * @param priority Priority of the current log.
     */
    open fun isLoggable(priority: Int): Boolean {
        return true
    }

    /**
     * Get the related StackTraceElement where the parent method is called.
     * It will contain useful information such as className, methodName, lineNumber etc.
     * Override this only if the StackTraceElement returned is incorrect.
     */
    protected open fun getStackTraceElement(): StackTraceElement {
        val stackTraceElements = Throwable().stackTrace
        if (stackTraceElements.size < callStackIndex) {
            throw IllegalStateException(
                "Synthetic stacktrace didn't have enough elements: are you using proguard?"
            )
        }
        return stackTraceElements[callStackIndex]
    }

    /**
     * Method to get stack trace from Throwable. This is from Timber (by Jake Wharton) which unhides UnknownHostException,
     * compared to default Android Log.getStackTraceString().
     *
     * @param t Throwable.
     */
    protected open fun getStackTraceString(t: Throwable): String {
        // Don't replace this with Log.getStackTraceString() - it hides
        // UnknownHostException, which is not what we want.
        val sw = StringWriter(256)
        val pw = PrintWriter(sw, false)
        t.printStackTrace(pw)
        pw.flush()
        return sw.toString()
    }

    /**
     * Actual log method. This is from Timber (by Jake Wharton) to split log according to maximum length defined by [MAX_LOG_LENGTH].
     *
     * @param priority Final priority of the log from [adjustPriority] method.
     * @param tag Tag generated from [getTag] method.
     * @param message Final message generated from [prepareLog] method.
     */
    protected open fun log(priority: Int, tag: String?, message: String) {
        if (message.length < MAX_LOG_LENGTH) {
            if (priority == Log.ASSERT) {
                Log.wtf(tag, message)
            } else {
                Log.println(priority, tag, message)
            }
            return
        }
        // Split by line, then ensure each line can fit into Log's maximum length.
        var i = 0
        val length = message.length
        while (i < length) {
            var newline = message.indexOf('\n', i)
            newline = if (newline != -1) newline else length
            do {
                val end = Math.min(newline, i + MAX_LOG_LENGTH)
                val part = message.substring(i, end)
                if (priority == Log.ASSERT) {
                    Log.wtf(tag, part)
                } else {
                    Log.println(priority, tag, part)
                }
                i = end
            } while (i < newline)
            i++
        }
    }

    // equals based on profileName
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as LogProfile
        if (profileName != other.profileName) return false
        return true
    }

    // hashCode based on profileName
    override fun hashCode(): Int {
        return profileName.hashCode()
    }

}