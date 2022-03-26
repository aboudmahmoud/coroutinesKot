package com.example.kotlincoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private  val _timerLiveData=MutableLiveData<Int>()
    public val timerLieData:MutableLiveData<Int> = _timerLiveData

    public fun startime()
    {
        viewModelScope.launch {
            for (i in 1..10)
            {
                _timerLiveData.value=i
                delay(1000)
            }
        }
    }
}