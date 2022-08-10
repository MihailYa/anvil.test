package com.mihailya.daggerpet.ui.di

import com.mihailya.daggerpet.ui.MainActivity
import com.squareup.anvil.annotations.MergeComponent

abstract class AnvilAppComponent private constructor()

@AppScope
@MergeComponent(
  AnvilAppComponent::class
)
interface AppComponent {
  fun injectActivity(activity: MainActivity)

  companion object {
    fun create(): AppComponent = DaggerAppComponent.create()
  }
}
