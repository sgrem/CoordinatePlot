// Top-level build file where you can add configuration options common to all sub-projects/modules.
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    id("com.google.devtools.ksp") version "1.9.0-1.0.11" apply false
    alias(libs.plugins.org.jetbrains.kotlin.jvm) apply false
}
true // Needed to make the Suppress annotation work for the plugins block
