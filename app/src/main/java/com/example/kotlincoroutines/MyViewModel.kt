package com.example.kotlincoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MyViewModel: ViewModel() {
    private  val _timerStateflow=MutableStateFlow<Int>(0)
    public val timerstateFlow:MutableStateFlow<Int> = _timerStateflow

    public fun startime()
    {
        viewModelScope.launch {
           val list= listOf<Int>(1,1,2,2,3,4,5,6,7,7,8,9,9,10)
            for (i in list)
            {
               // _timerStateflow.value=i
               _timerStateflow.emit(i)
                delay(1000)
            }
        }
    }
}