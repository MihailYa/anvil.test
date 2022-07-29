package com.mihailya.daggerpet.data

import javax.inject.Inject

class FooManager @Inject constructor() {
  fun getFooData() = "{data from FooManager}"
}