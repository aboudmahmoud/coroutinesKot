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
        val Parentjob:Job= Job()
        val job:Job=GlobalScope.launch(Parentjob) {
           val child1= launch { Database() }
            val child2=launch { Networke() }
         /*   //this mean wait child1 to finsh
            child1.join()
            //this mean wait child2 to finsh
            child2.join()
            //so that 2000 + 3000 will wait 5000 + 2000 wait agin in lunsh method */
            // or
            joinAll(child1,child2)
            launch { delay(2000) }
        }

    }
   private suspend fun Database():String
    {

            delay(2000)
            // binding.text.setText(textw)
           return "aboud"

    }
    private suspend fun Networke():String
    {

        delay(3000)
        // binding.text.setText(textw)
       return "aboud"

    }
}