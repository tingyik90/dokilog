[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](./index.md)

# LogProfile

`open class LogProfile`

Log profile which can be extended to customise log format.

### Parameters

`profileName` - Unique name for the profile. See [DokiLog.addProfile](../-doki-log/add-profile.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `LogProfile(profileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`)`<br>Log profile which can be extended to customise log format. |

### Properties

| Name | Summary |
|---|---|
| [callStackIndex](call-stack-index.md) | `var callStackIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Index for the StackTraceElement in [getStackTraceElement](get-stack-trace-element.md). This is dependent on your code. For this library, [callStackIndex](call-stack-index.md) = 3. Do not override this unless you are overriding other methods and the StackTraceElement returned is incorrect. |
| [filterTag](filter-tag.md) | `var filterTag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Custom tag used for filtering when going through logcat. Default = "Doki". By default, this is included in [getTag](get-tag.md) as part of the tag. |
| [profileName](profile-name.md) | `val profileName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Unique name for the profile. See [DokiLog.addProfile](../-doki-log/add-profile.md). |

### Functions

| Name | Summary |
|---|---|
| [adjustPriority](adjust-priority.md) | `open fun adjustPriority(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Adjust the priority for certain conditions. By default, there is no adjustment. Source code shows how to change the priority based on device manufacturer. |
| [equals](equals.md) | `open fun equals(other: `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`?): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [getStackTraceElement](get-stack-trace-element.md) | `open fun getStackTraceElement(): `[`StackTraceElement`](https://developer.android.com/reference/java/lang/StackTraceElement.html)<br>Get the related StackTraceElement where the parent method is called. It will contain useful information such as className, methodName, lineNumber etc. Override this only if the StackTraceElement returned is incorrect. |
| [getStackTraceString](get-stack-trace-string.md) | `open fun getStackTraceString(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Method to get stack trace from Throwable. This is from Timber (by Jake Wharton) which unhides UnknownHostException, compared to default Android Log.getStackTraceString(). |
| [getTag](get-tag.md) | `open fun getTag(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, stackTraceElement: `[`StackTraceElement`](https://developer.android.com/reference/java/lang/StackTraceElement.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Get defined tag for the log. Default has the format of "$filterTag - $className | ${stackTraceElement.methodName}" |
| [hashCode](hash-code.md) | `open fun hashCode(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [isLoggable](is-loggable.md) | `open fun isLoggable(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Sets the condition to log based on priority. Default = true. |
| [log](log.md) | `open fun log(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Actual log method. This is from Timber (by Jake Wharton) to split log according to maximum length defined by [MAX_LOG_LENGTH](-m-a-x_-l-o-g_-l-e-n-g-t-h.md). |
| [prepareLog](prepare-log.md) | `open fun prepareLog(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Entry point to the whole logging process. Prepare log based on message and throwable. If both are null, the message is set as "called", so that no message is swallowed. This is useful for checking the method calls sequence. For example, simply call v(), d(), etc. anywhere and it will return "methodName: called". |

### Companion Object Properties

| Name | Summary |
|---|---|
| [MAX_LOG_LENGTH](-m-a-x_-l-o-g_-l-e-n-g-t-h.md) | `const val MAX_LOG_LENGTH: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [MAX_TAG_LENGTH](-m-a-x_-t-a-g_-l-e-n-g-t-h.md) | `const val MAX_TAG_LENGTH: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
