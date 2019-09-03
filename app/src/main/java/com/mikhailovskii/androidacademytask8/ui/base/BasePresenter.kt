package com.mikhailovskii.androidacademytask8.ui.base

public open class BasePresenter<View>: MvpPresenter<View> {

    protected var view:View? = null;

    override fun attachView(view: View) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

}