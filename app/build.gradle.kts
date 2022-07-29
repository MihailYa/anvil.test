plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  id("com.squareup.anvil")
  id("kotlin-kapt")
  id("androidx.navigation.safeargs")
}

android {
  compileSdk = 32

  defaultConfig {
    applicationId = "com.mihailya.daggerpet"
    minSdk = 21
    targetSdk = 32
    versionCode = 1
    versionName = "1.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }

  buildTypes {
    getByName("release") {
      isMinifyEnabled = false
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
  }
  kotlinOptions {
    jvmTarget = "1.8"
  }

  buildFeatures {
    viewBinding = true
  }
}

dependencies {
  implementation(project(":timer-without-component-module"))
  implementation(project(":locale-with-component-module"))

  implementation("androidx.appcompat:appcompat:1.4.2")
  implementation("com.google.android.material:material:1.6.1")
  implementation("androidx.constraintlayout:constraintlayout:2.1.4")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.3")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

  implementation(libs.utils.viewBindingDelegate)

  // KTX
  implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.0-alpha01")
  implementation("androidx.core:core-ktx:1.8.0")
  implementation("androidx.fragment:fragment-ktx:1.5.0")

  implementation(libs.timber)

  implementation(libs.dagger2.dagger)
  kapt(libs.dagger2.compiler)

  implementation(libs.nav.fragment)
  implementation(libs.nav.ui)
}