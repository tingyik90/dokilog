[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](index.md) / [getStackTraceString](./get-stack-trace-string.md)

# getStackTraceString

`protected open fun getStackTraceString(t: `[`Throwable`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-throwable/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Method to get stack trace from Throwable. This is from Timber (by Jake Wharton) which unhides UnknownHostException,
compared to default Android Log.getStackTraceString().

### Parameters

`t` - Throwable.