package com.mikhailovskii.androidacademytask8.ui.progress

import com.mikhailovskii.androidacademytask8.ui.base.MvpPresenter
import com.mikhailovskii.androidacademytask8.ui.base.MvpView

interface ProgressContract {

    interface ProgressView: MvpView {

        fun updateProgress()

    }

    interface ProgressPresenter: MvpPresenter<ProgressView> {

        fun runService()

        fun runIntentService()

    }

}