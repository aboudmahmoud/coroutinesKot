package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        GlobalScope.launch(newSingleThreadContext("AboudTherd")) {
            Log.d("aboud", "ontherad:${Thread.currentThread().name} ")
            printmytext("hello")
        }
    }
    suspend fun printmytext(text:String)
    {
        delay(2000);
        Log.d("aboud", "text: "+text)
    }
}