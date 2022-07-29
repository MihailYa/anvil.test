package com.mihailya.timerwithoutcomponentmodule.di

import com.mihailya.timerwithoutcomponentmodule.Timer
import com.mihailya.timerwithoutcomponentmodule.TimerImpl
import com.squareup.anvil.annotations.ContributesTo
import dagger.Binds
import dagger.Module

@Module
@ContributesTo(TimerScope::class)
interface TimerModule {
  @Binds
  fun bindsTimer(timerImpl: TimerImpl): Timer
}
