package dependencies

object AndroidTestDependencies {
    val JUNIT by lazy { "junit:junit:4.13.2:${Versions.JUNIT}" }
    val EXT_JUNIT by lazy { "androidx.test.ext:junit:1.1.3:${Versions.EXT_JUNIT}" }
    val ESPRESSO by lazy { "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}" }
}
