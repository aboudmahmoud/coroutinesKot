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
        GlobalScope.launch {
           /* val getdata = Database()
            val getNetwrk=Networke()
            if (getdata==getNetwrk)
            {
                Log.d(TAG, "They Are Equal")
            }
            else{
                Log.d(TAG, "The Are Not Equal ")
            }*/

          val getdatabae=async { Database() }
         val getNetwork=async { Networke()}
            if (getdatabae.await()==getNetwork.await())
            {
                Log.d(TAG, "They Are Equal")
            }
            else{
                Log.d(TAG, "The Are Not Equal ")
            }

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