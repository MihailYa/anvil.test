package com.mihailya.daggerpet.ui

import androidx.lifecycle.ViewModel
import com.mihailya.daggerpet.data.SomeRepo
import com.mihailya.daggerpet.ui.di.AppScope
import com.mihailya.localecomponentmodule.CustomLocale
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@AppScope
class MainPlainViewModel @Inject constructor(
  someRepo: SomeRepo,
  customLocale: CustomLocale,
) : ViewModel() {

  val plainState = flowOf("Plain: \n${someRepo.getSome()}\n${customLocale.getCustomLocale()}")
}