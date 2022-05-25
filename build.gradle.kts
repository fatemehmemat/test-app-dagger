// Top-level build file where you can add configuration options common to all sub-projects/modules.
import com.diffplug.gradle.spotless.SpotlessExtensionPredeclare

plugins {
    id(Plugins.SPOTLESS)
}

configure<SpotlessExtensionPredeclare> {
    kotlin { ktlint(Versions.KTLINT) }
}

allprojects {
    repositories {
        google()
        mavenCentral()

    }
}
