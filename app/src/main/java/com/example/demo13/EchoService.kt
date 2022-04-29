package com.example.demo13

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class EchoService : Service() {
    companion object {
        const val LOG = "ECHO_SERVICE"
    }
    private var isRunning = false
    override fun onBind(p0: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()
        isRunning = true
        Log.v(LOG, "one term startup")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.v(LOG, "run each time with id=${startId}")
        doEcho()
        return super.onStartCommand(intent, flags, startId)
    }
    private fun doEcho() {
        Thread {
            var i = 0
            while (isRunning && i < 10) {
                Log.v(LOG, "finish part ${i}")
                Thread.sleep(1000)
                i++
            }
        }.start()

    }
    override fun onDestroy() {
        Log.v(LOG, "one term destroy")
        isRunning = false
        super.onDestroy()
    }
}