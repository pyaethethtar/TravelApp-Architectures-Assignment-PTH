package com.example.assignment5.mvp.presenters

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.assignment5.data.models.TourModel
import com.example.assignment5.data.models.TourModelImpl
import com.example.assignment5.fragments.MainFragment
import com.example.assignment5.mvp.views.MainView
import io.reactivex.android.schedulers.AndroidSchedulers

class MainPresenterImpl: MainPresenter, AbstractBasePresenter<MainView>() {



    private val mTourModel: TourModel= TourModelImpl


    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
        getAllTourData(lifecycleOwner)
    }

    override fun onTapItem(name: String) {
        mView?.navigatetoTourDetails(name)
    }

    private fun getAllTourData(lifecycleOwner: LifecycleOwner){

        mTourModel.getAllTours(onError = {
            Log.e("error", "tourError")
        }).observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayTours(it)
            }
        })
        mTourModel.getAllCountries(onError = {
            Log.e("error", "tourError")
        }).observe(lifecycleOwner, Observer {
            if (it.isNotEmpty()){
                mView?.displayCountries(it)
            }
        })

    }
}