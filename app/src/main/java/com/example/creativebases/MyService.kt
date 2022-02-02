package com.example.creativebases

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class MyService: Service() {

    lateinit var mPlayer: MediaPlayer

    lateinit var currThread: Thread

    override fun onCreate() {
        super.onCreate()

        mPlayer = MediaPlayer.create(this, R.raw.music)
        mPlayer.isLooping = true
    }

    override fun onBind(p0: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mPlayer.start()

        return START_STICKY
    }

    override fun onDestroy() {

        currThread.interrupt()
        super.onDestroy()
    }
}