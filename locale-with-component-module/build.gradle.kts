plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm")
  id("com.squareup.anvil")
  id("kotlin-kapt")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
  implementation(libs.dagger2.dagger)
  kapt(libs.dagger2.compiler)
}