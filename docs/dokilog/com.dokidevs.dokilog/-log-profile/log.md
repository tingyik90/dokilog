[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](index.md) / [log](./log.md)

# log

`protected open fun log(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, tag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Actual log method. This is from Timber (by Jake Wharton) to split log according to maximum length defined by [MAX_LOG_LENGTH](-m-a-x_-l-o-g_-l-e-n-g-t-h.md).

### Parameters

`priority` - Final priority of the log from [adjustPriority](adjust-priority.md) method.

`tag` - Tag generated from [getTag](get-tag.md) method.

`message` - Final message generated from [prepareLog](prepare-log.md) method.