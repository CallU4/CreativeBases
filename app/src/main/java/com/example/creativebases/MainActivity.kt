package com.example.creativebases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.creativebases.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bind: ActivityMainBinding

    private var isPlay = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        bind.button1.setOnClickListener {
            Intent(this@MainActivity, MyService::class.java).apply{
                startService(this)
            }
          //playMusic()
        }
    }

    fun playMusic(){
        isPlay = !isPlay
        var inte = Intent(this@MainActivity, MyService::class.java)
        startService(inte)
//        when(isPlay){
//            true -> startService(inte)
//            false -> stopService(inte)
//        }
    }
}