@file:JvmName("LiveDataTestObserverKt")

package com.lucas.coretesting.livedata

import androidx.lifecycle.LiveData

fun <T> LiveData<T>.test(): LiveDataTestObserver<T> {
  return LiveDataTestObserver.test(this)
}
