package com.dokidevs.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dokidevs.dokilog.DokiLog
import com.dokidevs.dokilog.v

open class BaseActivity : AppCompatActivity(), DokiLog {

    // Even if this is set to false, DemoActivity will still call all log method, since it overrides to "true".
    // The control lies with the last class which overrides this value.
    // Default = true. So there is no need for override unless you want to turn off log for a specific class.
    override val enableClassLog: Boolean
        get() = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // For ReleaseLogProfile example, we will modify VERBOSE to ERROR.
        v("This is called from BaseActivity")
        onCreateAction(savedInstanceState)
    }

    open fun onCreateAction(savedInstanceState: Bundle?) {}

    override fun onResume() {
        super.onResume()
        // This method is useful for checking method sequence.
        // That's how I track lifecycle of subclasses via a single parent class.
        v()
        onResumeAction()
    }

    open fun onResumeAction() {}

}