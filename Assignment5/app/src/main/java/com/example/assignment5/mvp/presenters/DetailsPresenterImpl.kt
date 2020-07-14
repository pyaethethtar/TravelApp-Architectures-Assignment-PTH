package com.example.assignment5.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.example.assignment5.data.models.TourModel
import com.example.assignment5.data.models.TourModelImpl
import com.example.assignment5.mvp.views.DetailsView

class DetailsPresenterImpl: DetailsPresenter, AbstractBasePresenter<DetailsView>() {

    private val mTourModel: TourModel = TourModelImpl

    override fun onTourDetailsUiReady(lifecycleOwner: LifecycleOwner, name: String) {
        mTourModel.getAllToursByName(name)?.observe(
            lifecycleOwner, Observer {
                if (it!=null){
                    mView?.displayTourDetails(it)
                }
            }
        )

        mTourModel.getAllCountryByName(name)?.observe(
            lifecycleOwner, Observer {
                if(it!=null){
                    mView?.displayCountryDetails(it)
                }
            }
        )


    }


}