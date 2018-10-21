[dokilog](../index.md) / [com.dokidevs.dokilog](./index.md)

## Package com.dokidevs.dokilog

### Types

| Name | Summary |
|---|---|
| [DokiLog](-doki-log/index.md) | `interface DokiLog`<br>Main interface for DokiLog. See [LogProfile](-log-profile/index.md) to customize logging. |
| [LogProfile](-log-profile/index.md) | `open class LogProfile`<br>Log profile which can be extended to customise log format. |

### Functions

| Name | Summary |
|---|---|
| [d](d.md) | `fun `[`DokiLog`](-doki-log/index.md)`.d(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](-doki-log/index.md)`.d(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.DEBUG](https://developer.android.com/reference/android/util/Log.html#DEBUG) level. |
| [e](e.md) | `fun `[`DokiLog`](-doki-log/index.md)`.e(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](-doki-log/index.md)`.e(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.ERROR](https://developer.android.com/reference/android/util/Log.html#ERROR) level. |
| [v](v.md) | `fun `[`DokiLog`](-doki-log/index.md)`.v(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](-doki-log/index.md)`.v(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.VERBOSE](https://developer.android.com/reference/android/util/Log.html#VERBOSE) level. |
| [w](w.md) | `fun `[`DokiLog`](-doki-log/index.md)`.w(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](-doki-log/index.md)`.w(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.WARN](https://developer.android.com/reference/android/util/Log.html#WARN) level. |
| [wtf](wtf.md) | `fun `[`DokiLog`](-doki-log/index.md)`.wtf(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`? = null, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>`fun `[`DokiLog`](-doki-log/index.md)`.wtf(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Log at [Log.ASSERT](https://developer.android.com/reference/android/util/Log.html#ASSERT) level. |
