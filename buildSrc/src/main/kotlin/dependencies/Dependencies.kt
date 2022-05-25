package dependencies

object Dependencies {
    //AndroidX
    val CORE_KTX by lazy { "androidx.core:core-ktx:${Versions.CORE_KTX}" }
    val APP_COMPAT by lazy { "androidx.appcompat:appcompat:${Versions.APP_COMPAT}" }
    val MATERIAL by lazy { "com.google.android.material:material:${Versions.MATERIAL}" }
    val CONSTRAIN_LAYOUT by lazy { "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAIN_LAYOUT}" }

    //Dagger
    val DAGGER by lazy { "com.google.dagger:dagger:${Versions.DAGGER}" }
    val DAGGER_ANDROID by lazy { "com.google.dagger:dagger-android:${Versions.DAGGER}" }
    val DAGGER_ANDROID_SUPPORT by lazy { "com.google.dagger:dagger-android-support:${Versions.DAGGER}" }


    //Coroutines
    val COROUTINES_CORE by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}" }
    val COROUTINES_ANDROID by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}" }


    //viewModel
    val LIFE_CYCLE_VIEW_MODEL by lazy { "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_LIVE_DATA by lazy { "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_RUNTIME by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_VIEW_MODEL_SAVE_STATE by lazy { "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_VIEW_MODEL_COMPOSE by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_COMMON by lazy { "androidx.lifecycle:lifecycle-common-java8:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_SERVICE by lazy { "androidx.lifecycle:lifecycle-service:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_PROCESS by lazy { "androidx.lifecycle:lifecycle-process:${Versions.LIFE_CYCLE}" }
    val LIFE_CYCLE_REACTIVESTREAMS by lazy { "androidx.lifecycle:lifecycle-reactivestreams-ktx:${Versions.LIFE_CYCLE}" }
    val CORE_TESTING by lazy { "androidx.arch.core:core-testing:${Versions.LIFE_CYCLE}" }

    //Room
    val ROOM_RUNTIME by lazy { "androidx.room:room-runtime:${Versions.ROOM}" }
    val ROOM_KTX by lazy { "androidx.room:room-ktx:${Versions.ROOM}" }
    val ROOM_GUAVA by lazy { "androidx.room:room-guava:${Versions.ROOM}" }
    val ROOM_PAGING by lazy { "androidx.room:room-paging:${Versions.ROOM}" }
    val ROOM_COMPILER by lazy { "androidx.room:room-compiler:${Versions.ROOM}" }
    val ROOM_TESTING by lazy { "androidx.room:room-testing:${Versions.ROOM}" }

    //Navigation
    val NAVIGATION_FRAGMENT by lazy { "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION}" }
    val NAVIGATION_UI by lazy { "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION}" }
    val NAVIGATION_FEATURES by lazy { "androidx.navigation:navigation-dynamic-features-fragment:${Versions.NAVIGATION}" }
    val NAVIGATION_COMPOSE by lazy { "androidx.navigation:navigation-compose:${Versions.NAVIGATION}" }

    //Recyclerview
    val RECYCLERVIEW by lazy { "androidx.recyclerview:recyclerview:${Versions.RECYCLER_VIEW}" }

    //data_store
    val DATA_SORE_PREFERENCES by lazy { "androidx.datastore:datastore-preferences:${Versions.DATA_STORE}" }
    val DATA_SORE_CORE by lazy { "androidx.datastore:datastore-core:${Versions.DATA_STORE}" }


    //RETROFIT
    val RETROFIT by lazy { "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}" }
    val RETROFIT_CONVERTOR by lazy { "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}" }
    val GSON by lazy { "com.squareup.retrofit2:converter-gson:${Versions.GSON}" }
    val INTERCEPTOR by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.INTERCEPTOR}" }








}

