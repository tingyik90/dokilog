[dokilog](../../index.md) / [com.dokidevs.dokilog](../index.md) / [DokiLog](index.md) / [addProfile](./add-profile.md)

# addProfile

`fun addProfile(logProfile: `[`LogProfile`](../-log-profile/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)

Add a log profile. This is similar to planting a tree in Timber (by Jake Wharton).
The profile name must be unique. Newly added profile will overwrite the old profile with the same name.

### Parameters

`logProfile` - Customizable [LogProfile](../-log-profile/index.md) which is identified by its name.