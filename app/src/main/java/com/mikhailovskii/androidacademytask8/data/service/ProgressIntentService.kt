package com.mikhailovskii.androidacademytask8.data.service

import android.app.IntentService
import android.content.Intent
import android.util.Log

class ProgressIntentService : IntentService("progress_intent_service") {

    override fun onHandleIntent(intent: Intent?) {
        Log.i("PROGRESS_INTENT_SERVICE", "Start")
        try {
            for (i in 0..100) {
                Thread.sleep(10)
                val responseIntent = Intent()
                responseIntent.action = INTENT_ACTION
                responseIntent.addCategory(Intent.CATEGORY_DEFAULT)
                responseIntent.putExtra(EXTRA_KEY_OUT, i)
                sendBroadcast(responseIntent)
            }
        } catch (e: InterruptedException) {
            e.stackTrace
        }
        Log.i("PROGRESS_INTENT_SERVICE", "Finish")


    }

    companion object{
        const val INTENT_ACTION = "com.mikhailovskii.androidacademytask8.data.service.PROGRESS"
        const val EXTRA_KEY_OUT = "EXTRA_KEY_OUT"
    }

}