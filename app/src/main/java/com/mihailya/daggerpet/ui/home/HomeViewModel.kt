package com.mihailya.daggerpet.ui.home

import androidx.lifecycle.ViewModel
import com.mihailya.daggerpet.ui.home.di.HomeScope
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

@HomeScope
class HomeViewModel @Inject constructor(): ViewModel() {
  val state = flowOf("SomeHomeState")
}
