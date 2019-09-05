package com.mikhailovskii.androidacademytask8.data.service

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.os.IBinder
import android.os.Process
import com.mikhailovskii.androidacademytask8.data.entities.Event
import org.greenrobot.eventbus.EventBus


class ProgressService : Service() {

    private var mHandlerThread: HandlerThread? = null
    private var mHandler: Handler? = null

    override fun onCreate() {
        super.onCreate()
        mHandlerThread = HandlerThread(
            ProgressService::class.java.simpleName,
            Process.THREAD_PRIORITY_BACKGROUND
        )
        mHandlerThread!!.start()

        mHandler = Handler(mHandlerThread!!.looper)
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        mHandler?.post { startUpdatingProgress() }
        return START_NOT_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        mHandlerThread!!.quit()
    }

    private fun startUpdatingProgress() {
        for (i in 0..100) {
            Thread.sleep(10)
            EventBus.getDefault().post(Event(i))
        }
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

}