package commons

import Modules
import dependencies.Dependencies

plugins {
    id("java-library")
    id("kotlin")
    id("com.android.lint")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

lint {
    lintConfig = rootProject.file("lint.xml")
    checkAllWarnings = true
    warningsAsErrors = true
}

dependencies {
    implementation(project(Modules.Core.UTILS))

    implementation(Dependencies.KOTLINX_COROUTINES_CORE)
}
