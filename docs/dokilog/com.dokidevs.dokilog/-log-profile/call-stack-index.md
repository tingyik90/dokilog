[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [LogProfile](index.md) / [callStackIndex](./call-stack-index.md)

# callStackIndex

`protected var callStackIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Index for the StackTraceElement in [getStackTraceElement](get-stack-trace-element.md). This is dependent on your code. For this library, [callStackIndex](./call-stack-index.md) = 3.
Do not override this unless you are overriding other methods and the StackTraceElement returned is incorrect.

