package com.example.assignment5.mvp.presenters

import androidx.lifecycle.ViewModel
import com.example.assignment5.mvp.views.BaseView

abstract class AbstractBasePresenter<T: BaseView>
    :    BasePresenter<T> , ViewModel(){

    var mView:T?=null

    override fun initPresenter(view: T) {
        mView=view
    }
}