package com.mihailya.daggerpet.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailya.daggerpet.R
import com.mihailya.daggerpet.base.WithViewModel
import com.mihailya.daggerpet.base.WithViewModelImpl
import com.mihailya.daggerpet.databinding.FragmentHomeBinding
import com.mihailya.daggerpet.ui.home.di.HomeComponent
import com.mihailya.daggerpet.utils.di.viewModelsProvider
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
import javax.inject.Provider

class HomeFragment : Fragment(), WithViewModel<HomeViewModel> by WithViewModelImpl() {

  private val binding by viewBinding(FragmentHomeBinding::bind)

  @Inject
  lateinit var homeViewModelProvider: Provider<HomeViewModel>

  private val homeViewModel by viewModelsProvider { homeViewModelProvider }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    HomeComponent.create().inject(this)

    homeViewModel.state
      .flowWithLifecycle(lifecycle)
      .onEach {
        binding.homeTextView.text = it
      }
      .launchIn(lifecycleScope)
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false)
  }
}