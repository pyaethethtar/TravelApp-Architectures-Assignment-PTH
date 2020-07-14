package com.example.assignment5.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.example.assignment5.mvp.views.DetailsView

interface DetailsPresenter : BasePresenter<DetailsView>{

    fun onTourDetailsUiReady(lifecycleOwner: LifecycleOwner, name: String)
}