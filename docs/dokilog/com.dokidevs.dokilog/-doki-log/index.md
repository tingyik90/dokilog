[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [DokiLog](./index.md)

# DokiLog

`interface DokiLog`

Main interface for DokiLog. See [LogProfile](../-log-profile/index.md) to customize logging.

### Properties

| Name | Summary |
|---|---|
| [className](class-name.md) | `open val className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Class name which DokiLog interface is attached to. This will show the subclass even if DokiLog is implemented in the parent class. To show the parent class name instead, get them from the [StackTraceElement.getClassName](https://developer.android.com/reference/java/lang/StackTraceElement.html#getClassName()) in [LogProfile.getTag](../-log-profile/get-tag.md). |
| [enableClassLog](enable-class-log.md) | `open val enableClassLog: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Enable log for the class which DokiLog interface is attached to. Override this to enable or disable log for the class. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [addProfile](add-profile.md) | `fun addProfile(logProfile: `[`LogProfile`](../-log-profile/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Add a log profile. This is similar to planting a tree in Timber (by Jake Wharton). The profile name must be unique. Newly added profile will overwrite the old profile with the same name. |
| [clearAllProfiles](clear-all-profiles.md) | `fun clearAllProfiles(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Remove all log profiles. |
| [hasLogProfiles](has-log-profiles.md) | `fun hasLogProfiles(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Check if log profiles are present before dispatching the log. |
| [log](log.md) | `fun log(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Actual execution method to loop through all log profiles. Entry point to [LogProfile.prepareLog](../-log-profile/prepare-log.md). You usually will not call this method directly. |
| [removeProfile](remove-profile.md) | `fun removeProfile(logProfile: `[`LogProfile`](../-log-profile/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Remove a log profile. This is similar to uprooting a tree in Timber (by Jake Wharton). |

### Extension Functions

| Name | Summary |
|---|---|
| [d](../d.md) | `fun `[`DokiLog`](./index.md)`.d(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](./index.md)`.d(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.DEBUG](https://developer.android.com/reference/android/util/Log.html#DEBUG) level. |
| [e](../e.md) | `fun `[`DokiLog`](./index.md)`.e(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](./index.md)`.e(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.ERROR](https://developer.android.com/reference/android/util/Log.html#ERROR) level. |
| [v](../v.md) | `fun `[`DokiLog`](./index.md)`.v(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](./index.md)`.v(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.VERBOSE](https://developer.android.com/reference/android/util/Log.html#VERBOSE) level. |
| [w](../w.md) | `fun `[`DokiLog`](./index.md)`.w(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](./index.md)`.w(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.WARN](https://developer.android.com/reference/android/util/Log.html#WARN) level. |
| [wtf](../wtf.md) | `fun `[`DokiLog`](./index.md)`.wtf(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](./index.md)`.wtf(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.ASSERT](https://developer.android.com/reference/android/util/Log.html#ASSERT) level. |
