# ProGuard rules
# Keep serialization
-keepattributes *Annotation*, InnerClasses
-dontnote kotlinx.serialization.AnnotationsKt
-keepclassmembers class kotlinx.serialization.json.** { *; }

# Keep Ktor
-keep class io.ktor.** { *; }

# Keep DataStore
-keep class androidx.datastore.** { *; }
