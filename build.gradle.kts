// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.6.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        val nav_version = "2.8.0"
        //noinspection GradleDependency
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")
    }
}