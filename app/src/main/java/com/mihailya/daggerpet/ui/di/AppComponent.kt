package com.mihailya.daggerpet.ui.di

import com.mihailya.daggerpet.ui.MainActivity
import com.mihailya.localecomponentmodule.di.LocaleComponent
import com.mihailya.timerwithoutcomponentmodule.di.TimerModule
import com.squareup.anvil.annotations.MergeComponent

abstract class AnvilAppComponent private constructor()

@AppScope
@MergeComponent(
  AnvilAppComponent::class,
  modules = [TimerModule::class],
  dependencies = [LocaleComponent::class]
)
interface AppComponent {
  fun injectActivity(activity: MainActivity)

  companion object {
    fun create(): AppComponent =
      DaggerAppComponent.builder()
        .localeComponent(LocaleComponent.create())
        .build()
  }
}
