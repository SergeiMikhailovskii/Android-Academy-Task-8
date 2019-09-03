package com.mikhailovskii.androidacademytask8.ui.progress

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mikhailovskii.androidacademytask8.R
import kotlinx.android.synthetic.main.activity_main.*

class ProgressActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_intent_service.setOnClickListener{
        }

        btn_service.setOnClickListener{
        }
    }

}
