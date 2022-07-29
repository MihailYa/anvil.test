package com.mihailya.daggerpet.ui

import androidx.lifecycle.ViewModel
import com.mihailya.daggerpet.data.SomeRepo
import com.mihailya.daggerpet.ui.di.AppScope
import com.mihailya.localecomponentmodule.CustomLocale
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.flowOf

class MainArgumentedViewModel @AssistedInject constructor(
  @Assisted private val someArgument: String,
  someRepo: SomeRepo,
  customLocale: CustomLocale,
) : ViewModel() {

  val someState = flowOf("Argumented: $someArgument\n${someRepo.getSome()}\n${customLocale.getCustomLocale()}")

  @AppScope
  @AssistedFactory
  interface Factory {
    fun create(someArgument: String): MainArgumentedViewModel
  }
}