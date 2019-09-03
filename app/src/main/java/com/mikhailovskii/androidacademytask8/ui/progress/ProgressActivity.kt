package com.mikhailovskii.androidacademytask8.ui.progress

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.mikhailovskii.androidacademytask8.R
import kotlinx.android.synthetic.main.activity_main.*

class ProgressActivity : AppCompatActivity(), ProgressContract.ProgressView {

    private val presenter = ProgressPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        btn_intent_service.setOnClickListener{
            presenter.runIntentService()
        }

        btn_service.setOnClickListener{
            presenter.runService()
        }
    }

    override fun updateProgress() {
        Toast.makeText(applicationContext, "Updated", Toast.LENGTH_SHORT).show()
    }

}
