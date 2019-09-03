package com.mikhailovskii.androidacademytask8.ui.base

interface MvpPresenter<View> {

    fun attachView(view: View)

    fun detachView()

}