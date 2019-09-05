package com.mikhailovskii.androidacademytask8.data.service

import android.app.IntentService
import android.content.Intent
import android.util.Log
import com.mikhailovskii.androidacademytask8.data.entities.EventNumber
import org.greenrobot.eventbus.EventBus


class ProgressIntentService : IntentService("progress_intent_service") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("ProgressIntentService", "In on handle intent")
        try {
            for (i in 0..100) {
                Thread.sleep(10)
                EventBus.getDefault().post(EventNumber(i))
            }
        } catch (e: InterruptedException) {
            e.stackTrace
        }
    }

}