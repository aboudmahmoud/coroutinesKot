package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow

class MainActivity : AppCompatActivity() {
    val TAG:String = "aboud";
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        runBlocking {
            flow<Int> {
                for (i in 1..10) {
                    delay(1000)
                    emit(i)
                    Log.d(TAG, "befor Filter ${i.toString()}")
                }
            }.filter { i: Int -> i < 5 }.collect {
                delay(3000)
                Log.d(TAG, "after Filter ${it.toString()}")
            }
        }
    }
}