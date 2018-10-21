[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](index.md) / [prepareLog](./prepare-log.md)

# prepareLog

`open fun prepareLog(priority: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`? = null, message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?, className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Entry point to the whole logging process. Prepare log based on message and throwable.
If both are null, the message is set as "called", so that no message is swallowed.
This is useful for checking the method calls sequence.
For example, simply call v(), d(), etc. anywhere and it will return "methodName: called".

### Parameters

`t` - Throwable.

`message` - Message.

**See Also**

[adjustPriority](adjust-priority.md)

