package com.mihailya.daggerpet.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mihailya.daggerpet.R
import com.mihailya.daggerpet.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {

  private val binding by viewBinding(FragmentMainBinding::bind)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

  }
}