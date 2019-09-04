package com.mikhailovskii.androidacademytask8.ui.progress

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.mikhailovskii.androidacademytask8.R
import com.mikhailovskii.androidacademytask8.data.entities.Event
import com.mikhailovskii.androidacademytask8.data.service.ProgressIntentService
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ProgressActivity : AppCompatActivity() {

    private val receiver = ActivityBroadcastReceiver(Handler())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_progress.text = "0"

        val intentFilter = IntentFilter(ProgressIntentService.INTENT_ACTION)
        registerReceiver(receiver, intentFilter)

        btn_intent_service.setOnClickListener {
            val intent = Intent(this, ProgressIntentService::class.java)
            startService(intent)
        }

        btn_service.setOnClickListener {
        }

    }

    override fun onStart() {
        super.onStart()
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        EventBus.getDefault().unregister(this)
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(receiver)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public fun onEvent(event: Event) {
        tv_progress.text = event.getI().toString()
    }


    //FIXME handler1 seems strange, but passing to constructor doesn't work
    inner class ActivityBroadcastReceiver(handler1: Handler) : BroadcastReceiver() {

        private val handler = handler1

        override fun onReceive(context: Context?, intent: Intent?) {
            Log.i("PROGRESS_INTENT_SERVICE", "Received")
            val progress = intent?.getIntExtra(ProgressIntentService.EXTRA_KEY_OUT, 0)
            handler.post { tv_progress.text = progress.toString() }
        }

    }

}
