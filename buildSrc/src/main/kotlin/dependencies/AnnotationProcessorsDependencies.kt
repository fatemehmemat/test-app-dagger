package dependencies

object AnnotationProcessorsDependencies {
    val DAGGER_COMPILER by lazy { "com.google.dagger:dagger-compiler:${Versions.DAGGER}" }
    val DAGGER_ANDROID_PROCESSOR by lazy { "com.google.dagger:dagger-android-processor:${Versions.DAGGER}" }
}
