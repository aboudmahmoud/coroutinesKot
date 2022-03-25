package com.example.kotlincoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.kotlincoroutines.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

class MainActivity : AppCompatActivity() {
    val TAG:String = "aboud";
    lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        runBlocking {
        var flow1= flow<Int> {
                for (i in 1..10) {

                    emit(i)

                }
            }
            var flow2= flow<String> {
                val list= listOf<String>("A","B","C","D")
                for (i in list) {
                    emit(i)

                }

            }
            flow1.zip(flow2)
            {
                    a:Int,b:String->"$a:$b"
            }.collect {
                Log.d(TAG,  "$it")
            }

        }
    }
}