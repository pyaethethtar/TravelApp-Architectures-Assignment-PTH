package com.example.assignment5.mvp.presenters

import com.example.assignment5.mvp.views.BaseView
import com.example.assignment5.mvp.views.MainView

interface BasePresenter<T: BaseView> {

    fun initPresenter(view: T)
}