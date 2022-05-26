package dependencies

object Dependencies {
    //AndroidX
    const val CORE_KTX = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAIN_LAYOUT =
        "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAIN_LAYOUT}"

    //Dagger
    const val DAGGER = "com.google.dagger:dagger:${Versions.DAGGER}"
    const val DAGGER_ANDROID = "com.google.dagger:dagger-android:${Versions.DAGGER}"
    const val DAGGER_ANDROID_SUPPORT = "com.google.dagger:dagger-android-support:${Versions.DAGGER}"

    //Coroutines
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions
    .COROUTINES}"
    const val COROUTINES_ANDROID =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"

    //viewModel
    const val LIFE_CYCLE_VIEW_MODEL =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_LIVE_DATA =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_VIEW_MODEL_SAVE_STATE =
        "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_VIEW_MODEL_COMPOSE =
        "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_COMMON = "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_SERVICE = "androidx.lifecycle:lifecycle-service:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_PROCESS = "androidx.lifecycle:lifecycle-process:${Versions.LIFE_CYCLE}"
    const val LIFE_CYCLE_REACTIVESTREAMS =
        "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.LIFE_CYCLE}"
    const val CORE_TESTING = "androidx.arch.core:core-testing:${Versions.LIFE_CYCLE}"

    //Room
    const val ROOM_RUNTIME = "androidx.room:room-runtime:${Versions.ROOM}"
    const val ROOM_KTX = "androidx.room:room-ktx:${Versions.ROOM}"
    const val ROOM_GUAVA = "androidx.room:room-guava:${Versions.ROOM}"
    const val ROOM_PAGING = "androidx.room:room-paging:${Versions.ROOM}"
    const val ROOM_TESTING = "androidx.room:room-testing:${Versions.ROOM}"

    //Navigation
    const val NAVIGATION_FRAGMENT =
        "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_UI = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}"
    const val NAVIGATION_FEATURES =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}"
    const val NAVIGATION_COMPOSE = "androidx.navigation:navigation-compose:${Versions.NAVIGATION}"

    //Recyclerview
    const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}"

    //data_store
    const val DATA_SORE_PREFERENCES =
        "androidx.datastore:datastore-preferences:${Versions.DATA_STORE}"
    const val DATA_SORE_CORE = "androidx.datastore:datastore-core:${Versions.DATA_STORE}"

    //RETROFIT
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val RETROFIT_CONVERTOR = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val GSON = "com.squareup.retrofit2:converter-gson:${Versions.GSON}"
    const val INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.INTERCEPTOR}"
}
