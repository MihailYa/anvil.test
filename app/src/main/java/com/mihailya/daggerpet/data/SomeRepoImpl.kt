package com.mihailya.daggerpet.data

import com.mihailya.daggerpet.ui.di.AnvilAppComponent
import com.mihailya.daggerpet.ui.di.AppScope
import com.mihailya.timerwithoutcomponentmodule.Timer
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@AppScope
@ContributesBinding(AnvilAppComponent::class)
class SomeRepoImpl @Inject constructor(
  private val timer: Timer,
  private val fooManager: FooManager
) : SomeRepo {
  private val repoCount = repoInstancesCounter++
  override fun getSome(): String {
    return "{Some $repoCount value from SomeRepoImpl}${timer.getData()}${fooManager.getFooData()}"
  }
}

private var repoInstancesCounter: Int = 0