package com.mihailya.daggerpet.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailya.daggerpet.R.layout
import com.mihailya.daggerpet.databinding.ActivityMainBinding
import com.mihailya.daggerpet.ui.di.AppComponent
import com.mihailya.daggerpet.utils.di.viewModelsFactory
import com.mihailya.daggerpet.utils.di.viewModelsProvider
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity() {
  private val someArgument = "Argument from MainActivity"

  private val viewBinding by viewBinding(ActivityMainBinding::bind)

  @Inject
  lateinit var argumentedViewModelFactory: MainArgumentedViewModel.Factory

  private val argumentedViewModel: MainArgumentedViewModel by viewModelsFactory {
    argumentedViewModelFactory.create(
      someArgument
    )
  }

  @Inject
  lateinit var plainViewModelFactory: Provider<MainPlainViewModel>

  private val plainViewModel: MainPlainViewModel by viewModelsProvider { plainViewModelFactory }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)

    AppComponent.create().injectActivity(this)

    argumentedViewModel.someState
      .flowWithLifecycle(lifecycle)
      .onEach {
        viewBinding.mainTextView.text = it
      }
      .launchIn(lifecycleScope)

    plainViewModel.plainState
      .flowWithLifecycle(lifecycle)
      .onEach {
        viewBinding.secondTextView.text = it
      }
      .launchIn(lifecycleScope)
  }
}