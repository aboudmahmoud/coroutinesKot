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
            val list= listOf<Int>(1,1,2,2,3,4,5,6,7,7,8,9,9,10)
            for (i in list)
            {
                _timerLiveData.value=i
                delay(1000)
            }
        }
    }
}