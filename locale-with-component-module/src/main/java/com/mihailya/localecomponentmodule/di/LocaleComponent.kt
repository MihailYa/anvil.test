package com.mihailya.localecomponentmodule.di

import com.mihailya.localecomponentmodule.CustomLocale
import com.squareup.anvil.annotations.MergeComponent

@MergeComponent(LocaleScope::class)
interface LocaleComponent {
  fun customLocale(): CustomLocale

  companion object {
    fun create(): LocaleComponent {
      return DaggerLocaleComponent.create()
    }
  }
}