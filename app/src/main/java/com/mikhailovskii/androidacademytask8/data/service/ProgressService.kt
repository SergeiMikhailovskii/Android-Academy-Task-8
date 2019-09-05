package com.mikhailovskii.androidacademytask8.data.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.mikhailovskii.androidacademytask8.data.entities.Event
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class ProgressService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startUpdatingProgress()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startUpdatingProgress() {
        Thread(Runnable {
            try {
                for (i in 0..100) {
                    Thread.sleep(10)
                    EventBus.getDefault().post(Event(i))
                    Log.i("ProgressService", i.toString())
                }
            } catch (e: InterruptedException) {
                e.stackTrace
            }
        }).run()
    }

}