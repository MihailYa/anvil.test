package com.mihailya.daggerpet.ui.home.di

import com.mihailya.daggerpet.ui.home.HomeFragment
import com.squareup.anvil.annotations.MergeComponent

abstract class AnvilHomeComponent private constructor()

@HomeScope
@MergeComponent(AnvilHomeComponent::class)
interface HomeComponent {
  fun inject(homeFragment: HomeFragment)

  companion object {
    fun create(): HomeComponent {
      return DaggerHomeComponent.create()
    }
  }
}