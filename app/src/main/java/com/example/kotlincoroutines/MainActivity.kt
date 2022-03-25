package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel

class MainActivity : AppCompatActivity() {
    val TAG:String = "aboud";
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)
        val kotlinChannel=Channel<String>()
        val charlist= arrayOf("a","b","c","d")
        runBlocking {
            launch {
                var count:Int=0
                for (char in charlist)
                {
                    kotlinChannel.offer((char+" "+count))
                    count++
                //  delay(1)
                }
            }

                for (char in kotlinChannel){
                    Log.d(TAG, char)
                }

        }

    }
}