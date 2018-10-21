[![](https://jitpack.io/v/tingyik90/dokilog.svg)](https://jitpack.io/#tingyik90/dokilog)

# DokiLog
Pleasant Android + Kotlin logging by DokiDevs. Inspired by `Timber` + `AnkoLogger`.

## Features
1. Use different `LogProfile` for different builds. Similar to how you plant your tree in `Timber`.
2. Get subclass name directly like `AnkoLogger`. You can only get parent class via `Timber`.
3. Enable / disable logging at class level via `enableClassLog`.
4. Everything is extendable! Customise `LogProfile` to suit your needs!

## Getting Started
### Application
In your `Application` class, create a `LogProfile` with a unique name and add it to `DokiLog`.

IMPORTANT: Default `LogProfile` is suitable for DEBUG purpose only. Do not use it for RELEASE!! 

```kotlin
class DemoApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        
        if (BuildConfig.DEBUG) {
            // Use the default log profile and give it a name, this should be sufficient for most cases.
            DokiLog.addProfile(LogProfile("Debug"))
        } else {
            // You should always customise your LogProfile for release use!! Beware of information leak!!!
        }
    }
    
}
```

### DokiLog
Similar to `AnkoLogger`, implements `DokiLog` interface to your class and start logging!

Default format of log print is `{filterTag} - {subClass} | {method}: {message}`

```kotlin
open class BaseActivity: AppCompatActivity(), DokiLog {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        v("This is called from BaseActivity")
        // v for VERBOSE, d for DEBUG... etc.
        // Output: Doki - BaseActivity | onCreate: This is called from BaseActivity
        
        v()
        // Output: Doki - BaseActivity | onCreate: called
        // Empty argument will automatically replace message with 'called'.
        // This is useful for tracking method call sequence.
    }
    
}
```

Continuing from above, you can extend `BaseActivity` and the log will still be printed.
Notice that the class name is `DemoActivity` even though the log for `onCreate` is called in `BaseActivity`.

```kotlin
class DemoActivity: BaseActivity() {
    
    override onResume() {
        v("This is called from DemoActivity")
        // Output:
        // Doki - DemoActivity | onCreate: This is called from BaseActivity
        // Doki - DemoActivity | onResume: This is called from DemoActivity
    }
    
}
```

You can disable logging for a specific class by calling

```kotlin
class DemoActivity: BaseActivity() {
    
    override val enableClassLog: Boolean
        get() = false
    // Set this to FALSE and all logs related to DemoActivity (including those called in BaseActivity)
    // will not be shown. However, if you mark this as FALSE in BaseActivity, and TRUE in DemoActivity,
    // all logs will still be shown. The control lies with the last class which overrides this value.
```

### LogProfile
IMPORTANT: Default `LogProfile` is suitable for DEBUG purpose only. Do not use it for RELEASE!!

To customise, extend `LogProfile`. Some main methods to override are as below.

```kotlin
class ReleaseLogProfile: LogProfile("Release") {  // Give it a unique profile name

    init {
        // Give it a new filter tag if you wish to. Default = "Doki"
        // This is useful for filtering in logcat.
        filterTag = "MyAppName"
    }
    
    // Modify priority for certain devices
    override fun adjustPriority(priority: Int): Int {
        if (Build.MANUFACTURER.equals("huawei", true) ||
            Build.MANUFACTURER.equals("samsung", true)
        ) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return Log.INFO
            }
        }
        return priority
    }

    // Only log for ERROR and ASSERT
    override fun isLoggable(priority: Int): Boolean {
        return priority == Log.ERROR || priority == Log.ASSERT
    }

    // Use the parent class name instead of subclass name (as shown in example above)
    override fun getTag(className: String, stackTraceElement: StackTraceElement): String {
        val tag = "$filterTag - ${stackTraceElement.className} | ${stackTraceElement.methodName}"
        if (tag.length <= MAX_TAG_LENGTH || Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return tag
        }
        return tag.substring(0, MAX_TAG_LENGTH)
    }

}
```

## KDoc
For further information, see https://tingyik90.github.io/dokilog/dokilog/.
See `app/demo` section for more.

## Download
In the project Gradle:
```Gradle
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```

In the app Gradle:
```Gradle
dependencies {
    implementation 'com.github.tingyik90:DokiLog:version'
}
```

## License
Copyright 2018 Saw Ting Yik

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
