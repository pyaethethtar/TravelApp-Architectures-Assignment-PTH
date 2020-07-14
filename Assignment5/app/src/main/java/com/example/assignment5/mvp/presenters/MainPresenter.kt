package com.example.assignment5.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.example.assignment5.delegates.TourItemDelegate
import com.example.assignment5.mvp.views.MainView

interface MainPresenter : TourItemDelegate, BasePresenter<MainView>{


   fun onUiReady(lifecycleOwner: LifecycleOwner)

}