package commons

import AndroidConfigs
import Build
import DebugBuild
import ReleaseBuild
import dependencies.Dependencies
import extensions.implementation
import gradle.kotlin.dsl.accessors._36626f7cafa7add98e7dfe6126f1faec.implementation

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("androidx.navigation.safeargs")
}

android {
    compileSdk = AndroidConfigs.COMPILE_SDK

    defaultConfig {
        minSdk = AndroidConfigs.MIN_SDK
        targetSdk = AndroidConfigs.TARGET_SDK

        testInstrumentationRunner = AndroidConfigs.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName(Build.RELEASE) {
            isMinifyEnabled = ReleaseBuild.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName(Build.DEBUG) {
            isMinifyEnabled = DebugBuild.isMinifyEnabled
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
    }

    lint {
        lintConfig = rootProject.file("lint.xml")
        checkAllWarnings = true
        warningsAsErrors = true
    }
}

dependencies {
    implementation(project(Modules.COMMONS))
    implementation(project(Modules.DOMAIN))
    implementation(project(Modules.DATA))
    implementation(project(Modules.Core.UTILS))
    implementation(project(Modules.Core.VIEWS))

    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)

    implementation(Dependencies.DAGGER_ANDROID)
    implementation(Dependencies.DAGGER_ANDROID_SUPPORT)

    implementation(Dependencies.KOTLINX_COROUTINES_ANDROID)

    implementation(Dependencies.NAVIGATION_FRAGMENT_KTX)
    implementation(Dependencies.NAVIGATION_UI_KTX)
}
