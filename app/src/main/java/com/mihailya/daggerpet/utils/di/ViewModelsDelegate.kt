package com.mihailya.daggerpet.utils.di

import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import javax.inject.Provider

inline fun <reified VM : ViewModel> ComponentActivity.viewModelsProvider(
  crossinline viewModelProducer: () -> Provider<VM>,
): Lazy<VM> = viewModelsFactory { viewModelProducer().get() }

inline fun <reified VM : ViewModel> ComponentActivity.viewModelsFactory(
  crossinline viewModelProducer: () -> VM,
): Lazy<VM> = viewModels {
  viewModelFactory {
    initializer {
      viewModelProducer()
    }
  }
}

inline fun <reified VM : ViewModel> Fragment.viewModelsProvider(
  crossinline viewModelProducer: () -> Provider<VM>,
): Lazy<VM> = viewModelsFactory { viewModelProducer().get() }

inline fun <reified VM : ViewModel> Fragment.viewModelsFactory(
  crossinline viewModelProducer: () -> VM,
): Lazy<VM> = viewModels {
  viewModelFactory {
    initializer {
      viewModelProducer()
    }
  }
}