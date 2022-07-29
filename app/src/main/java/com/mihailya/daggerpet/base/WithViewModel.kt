package com.mihailya.daggerpet.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.viewModelFactory
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

interface WithViewModel<VM : ViewModel> {
  var viewModelProvider: Provider<VM>
  val viewModel: VM
}

class WithViewModelImpl<VM : ViewModel> @PublishedApi internal constructor(
  type: KClass<VM>,
  parent: Fragment
) : WithViewModel<VM> {
  @Inject
  override lateinit var viewModelProvider: Provider<VM>

  override val viewModel: VM by lazy {
    ViewModelProvider(parent, viewModelFactory {
      addInitializer(type) {
        viewModelProvider.get()
      }
    })[type.java]
  }

  companion object {
    inline operator fun <reified T : ViewModel> invoke(parent: Fragment) =
      WithViewModelImpl(T::class, parent)
  }
}