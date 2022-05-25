import dependencies.AndroidTestDependencies
import dependencies.Dependencies
import dependencies.TestDependencies

plugins {
    id(Plugins.ANDROID_APPLICATION)
    id("org.jetbrains.kotlin.android")
}

dependencies {
    implementation(Dependencies.APP_COMPAT)
    implementation(Dependencies.MATERIAL)
    implementation(Dependencies.CONSTRAIN_LAYOUT)

    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.COROUTINES_ANDROID)



    implementation(Dependencies.LIFE_CYCLE_VIEW_MODEL)
    implementation(Dependencies.LIFE_CYCLE_LIVE_DATA)
    implementation(Dependencies.LIFE_CYCLE_RUNTIME)
    implementation(Dependencies.LIFE_CYCLE_VIEW_MODEL_SAVE_STATE)
    implementation(Dependencies.LIFE_CYCLE_VIEW_MODEL_COMPOSE)
    implementation(Dependencies.LIFE_CYCLE_COMMON)
    implementation(Dependencies.LIFE_CYCLE_SERVICE)
    implementation(Dependencies.LIFE_CYCLE_PROCESS)
    implementation(Dependencies.LIFE_CYCLE_REACTIVESTREAMS)
    implementation(Dependencies.DATA_SORE_PREFERENCES)
    implementation(Dependencies.DATA_SORE_CORE)
    testImplementation(Dependencies.CORE_TESTING)


    implementation(Dependencies.ROOM_RUNTIME)
    implementation(Dependencies.ROOM_KTX)
    implementation(Dependencies.ROOM_GUAVA)
    implementation(Dependencies.ROOM_PAGING)
    kapt(Dependencies.ROOM_COMPILER)
    testImplementation(Dependencies.ROOM_TESTING)

    implementation(Dependencies.NAVIGATION_FRAGMENT)
    implementation(Dependencies.NAVIGATION_UI)
    implementation(Dependencies.NAVIGATION_FEATURES)
    implementation(Dependencies.NAVIGATION_COMPOSE)


    implementation(Dependencies.RECYCLERVIEW)

    implementation(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_CONVERTOR)
    implementation(Dependencies.GSON)
    implementation(Dependencies.INTERCEPTOR)


    testImplementation(TestDependencies.JUNIT)
    androidTestImplementation(AndroidTestDependencies.EXT_JUNIT)
    androidTestImplementation(AndroidTestDependencies.ESPRESSO)

}