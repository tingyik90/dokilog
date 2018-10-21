[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [DokiLog](index.md) / [className](./class-name.md)

# className

`open val className: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)

Class name which DokiLog interface is attached to.
This will show the subclass even if DokiLog is implemented in the parent class.
To show the parent class name instead, get them from the [StackTraceElement.getClassName](https://developer.android.com/reference/java/lang/StackTraceElement.html#getClassName()) in [LogProfile.getTag](../-log-profile/get-tag.md).

