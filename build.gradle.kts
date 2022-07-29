// Top-level build file where you can add configuration options common to all sub-projects/modules.
//apply from: rootProject.file("dependencies.gradle")

buildscript {
  dependencies {
    classpath(libs.nav.args)
  }
}

plugins {
  id("com.android.application") version "7.2.1" apply false
  id("com.android.library") version "7.2.1" apply false
  id("org.jetbrains.kotlin.android") version "1.7.10" apply false
  id("com.squareup.anvil") version "2.4.1"
  id("org.jetbrains.kotlin.jvm") version "1.7.10" apply false
}

tasks.register<Delete>("clean") {
  delete(rootProject.buildDir)
}
