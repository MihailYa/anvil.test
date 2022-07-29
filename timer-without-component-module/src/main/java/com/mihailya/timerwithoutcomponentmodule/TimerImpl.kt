package com.mihailya.timerwithoutcomponentmodule

import javax.inject.Inject

class TimerImpl @Inject constructor(): Timer {
  override fun getData(): String {
    return "{data from timer-without-component-module}"
  }
}