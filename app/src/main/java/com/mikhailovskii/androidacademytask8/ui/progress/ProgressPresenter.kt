package com.mikhailovskii.androidacademytask8.ui.progress

import com.mikhailovskii.androidacademytask8.ui.base.BasePresenter

class ProgressPresenter(): BasePresenter<ProgressContract.ProgressView>(), ProgressContract.ProgressPresenter {

    override fun runService() {
        view?.updateProgress()
    }

    override fun runIntentService() {
        view?.updateProgress()
    }

}