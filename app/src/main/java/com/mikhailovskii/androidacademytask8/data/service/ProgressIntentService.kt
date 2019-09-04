package com.mikhailovskii.androidacademytask8.data.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.mikhailovskii.androidacademytask8.data.entities.Event
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe


class ProgressIntentService : IntentService("progress_intent_service") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("PROGRESS_INTENT_SERVICE", "Start")
        try {
            for (i in 0..100) {
                Thread.sleep(10)
                EventBus.getDefault().post(Event(i))
            }
        } catch (e: InterruptedException) {
            e.stackTrace
        }
        Log.i("PROGRESS_INTENT_SERVICE", "Finish")


    }

    @Subscribe
    public fun onEvent(event: Event){
        
    }

    override fun onCreate() {
        super.onCreate()
        EventBus.getDefault().register(this)
    }

    override fun onDestroy() {
        EventBus.getDefault().unregister(this)
        super.onDestroy()
    }

    companion object {
        const val INTENT_ACTION = "com.mikhailovskii.androidacademytask8.data.service.PROGRESS"
        const val EXTRA_KEY_OUT = "EXTRA_KEY_OUT"
    }

}