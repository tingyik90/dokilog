package com.dokidevs.demo

import android.os.Bundle
import com.dokidevs.dokilog.*
import java.lang.IndexOutOfBoundsException

class DemoActivity : BaseActivity(), DokiLog {

    // Set this to false and all log related to DemoActivity (including those called in BaseActivity) will not be shown anymore.
    override val enableClassLog: Boolean
        get() = true

    override fun onCreateAction(savedInstanceState: Bundle?) {
        d("This is called from DemoActivity")
        setContentView(R.layout.activity_demo)
    }

    override fun onResumeAction() {
        try {
            val list = listOf<Int>()
            list[1].toString()
        } catch (ex: IndexOutOfBoundsException) {
            w("This is shown in Debug Only", ex)
            wtf(ex)
        }
    }

    // For default log profile, we should see the log of:
    // V/Doki - DemoActivity | onCreate: This is called from BaseActivity
    // D/Doki - DemoActivity | onCreateAction: This is called from DemoActivity
    // V/Doki - DemoActivity | onResume: called                                                     (No argument method is replaced with "called")
    // W/Doki - DemoActivity | onResumeAction: This is shown in Debug Only
    //          java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 1.
    // E/Doki - DemoActivity | onResumeAction: java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 1.

    // For release log profile, we should see the log of:
    // E/Release - com.dokidevs.demo.BaseActivity | onCreate: This is called from BaseActivity      (VERBOSE is changed to ERROR level)
    // E/Release - com.dokidevs.demo.BaseActivity | onResume: called                                (VERBOSE is changed to ERROR level)
    // E/Release - com.dokidevs.demo.DemoActivity | onResumeAction: java.lang.IndexOutOfBoundsException: Empty list doesn't contain element at index 1.

    // Notice how the "filterTag", "priority", "className" are different in both profiles.

}
