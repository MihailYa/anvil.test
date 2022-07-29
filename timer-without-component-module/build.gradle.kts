plugins {
  id("java-library")
  id("org.jetbrains.kotlin.jvm")
  id("com.squareup.anvil")
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

anvil {
  generateDaggerFactories.set(true)
}

dependencies {
  implementation(libs.dagger2.dagger)
}