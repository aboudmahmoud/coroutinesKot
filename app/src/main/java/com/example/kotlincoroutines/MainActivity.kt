package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    val TAG:String = "aboud";
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
       // runBlocking { printmytext("aboud") }
        Log.d(TAG, "main therd")
       runBlocking {
            printmytext("aboud")
        }
        Log.d(TAG, " back to main therd")
    }
    suspend fun printmytext(textw:String)
    { delay(2000)
            // binding.text.setText(textw)
        Log.d(TAG, "The assowm is ${textw}")
    }
}