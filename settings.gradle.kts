enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
  repositories {
    gradlePluginPortal()
    google()
    mavenCentral()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}
rootProject.name = "DaggerPet"
include(":app")
include(":timer-without-component-module")
include(":locale-with-component-module")

// ext {
//   daggerVersion = "2.42"
//   navVersion = "2.5.1"
//
//   deps = [
//       dagger2: [
//           dagger: "com.google.dagger:dagger:$daggerVersion",
//           compiler: "com.google.dagger:dagger-compiler:$daggerVersion"
//       ],
//       timber: "com.jakewharton.timber:timber:5.0.1",
//       utils: [
//         viewBindingDelegate: "com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.5.6"
//       ],
//       nav: [
//           fragment: "androidx.navigation:navigation-fragment-ktx:$navVersion",
//           ui: "androidx.navigation:navigation-ui-ktx:$navVersion",
//           plugin: "androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion"
//       ]
//   ]
// }
//
