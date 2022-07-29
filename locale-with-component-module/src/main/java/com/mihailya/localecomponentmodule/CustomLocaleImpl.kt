package com.mihailya.localecomponentmodule

import com.mihailya.localecomponentmodule.di.LocaleScope
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(LocaleScope::class)
class CustomLocaleImpl @Inject constructor(): CustomLocale {
  override fun getCustomLocale(): String {
    return "{data from 'locale-with-component-module'}"
  }
}