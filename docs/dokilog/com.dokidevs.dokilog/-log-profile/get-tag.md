[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](index.md) / [getTag](./get-tag.md)

# getTag

`protected open fun getTag(className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, stackTraceElement: `[`StackTraceElement`](https://developer.android.com/reference/java/lang/StackTraceElement.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Get defined tag for the log. Default has the format of
"$filterTag - $className | ${stackTraceElement.methodName}"

### Parameters

`stackTraceElement` - StackTraceElement returned from [getStackTraceElement](get-stack-trace-element.md).