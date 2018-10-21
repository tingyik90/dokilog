[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](index.md) / [getStackTraceElement](./get-stack-trace-element.md)

# getStackTraceElement

`protected open fun getStackTraceElement(): `[`StackTraceElement`](https://developer.android.com/reference/java/lang/StackTraceElement.html)

Get the related StackTraceElement where the parent method is called.
It will contain useful information such as className, methodName, lineNumber etc.
Override this only if the StackTraceElement returned is incorrect.

