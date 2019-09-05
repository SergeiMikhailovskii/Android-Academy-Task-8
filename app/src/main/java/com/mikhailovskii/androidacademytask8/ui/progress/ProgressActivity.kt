package com.mikhailovskii.androidacademytask8.ui.progress

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.mikhailovskii.androidacademytask8.R
import com.mikhailovskii.androidacademytask8.data.entities.EventNumber
import com.mikhailovskii.androidacademytask8.data.entities.ToastEvent
import com.mikhailovskii.androidacademytask8.data.service.ProgressIntentService
import com.mikhailovskii.androidacademytask8.data.service.ProgressService
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class ProgressActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv_progress.text = "0"

        btn_intent_service.setOnClickListener {
            val intent = Intent(this, ProgressIntentService::class.java)
            startService(intent)
        }

        btn_service.setOnClickListener {
            val intent = Intent(this, ProgressService::class.java)
            startService(intent)
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventNumber(eventNumber: EventNumber) {
        tv_progress.text = eventNumber.getI().toString()
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventToast(eventToast: ToastEvent){
        Toast.makeText(this, eventToast.getMessage(), Toast.LENGTH_SHORT).show()
    }

}
