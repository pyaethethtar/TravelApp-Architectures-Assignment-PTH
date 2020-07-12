package com.example.assignment5.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.assignment5.R
import com.example.assignment5.adapters.CountryAdapter
import com.example.assignment5.adapters.TourAdapter
import com.example.assignment5.data.models.TourModel
import com.example.assignment5.data.models.TourModelImpl
import com.example.assignment5.delegates.TourItemDelegate
import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), TourItemDelegate {


    lateinit var mTourModel: TourModel
    lateinit var tourAdapter:TourAdapter
    lateinit var countryAdapter:CountryAdapter
    lateinit var mView: View
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mView=view
        mTourModel=TourModelImpl(mView.context)
        setUpRecyclerView()
        requestData()
    }

    override fun onTapItem(name: String) {
        val transaction=fragmentManager?.beginTransaction()
        transaction?.replace(R.id.flContainer, DetailFragment(name))
        transaction?.addToBackStack(null)
        transaction?.commit()
    }

    private fun setUpRecyclerView(){

        val hLayoutManager= LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvCountry.layoutManager=hLayoutManager
        countryAdapter= CountryAdapter(this)
        rvCountry.adapter=countryAdapter

        val vLayoutManager= LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        rvPopularTours.layoutManager=vLayoutManager
        tourAdapter= TourAdapter(this)
        rvPopularTours.adapter=tourAdapter
    }

    private fun requestData(){

        mTourModel.getToursAndCountries()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
            if (it.country.isNotEmpty()){
                countryAdapter.setNewData(it.country.toMutableList())
            }
            if (it.tour.isNotEmpty()){
                tourAdapter.setNewData(it.tour.toMutableList())
            }
        }.addTo(compositeDisposable)



//        mTourModel.getToursAndCountries()
//            .subscribe {
//                countryAdapter.setNewData(it.country.toMutableList())
//                tourAdapter.setNewData(it.tour.toMutableList())
//            }.addTo(compositeDisposable)



        //swipeRefreshLayout.isRefreshing=true
//        mTourModel.getAllTours(
//            onSuccess = {
//
//                if (it.isNotEmpty()){
//                    tourAdapter.setNewData(it)
//                }
//                else{
//                    Snackbar.make(mView, "Empty", Snackbar.LENGTH_LONG)
//                }
//                //swipeRefreshLayout.isRefreshing=false
//            },
//            onFailure = {
//                Snackbar.make(mView, it, Snackbar.LENGTH_LONG)
//            }
//
//        )
//        mTourModel.getAllCountries(
//            onSuccess = {
//                if (it.isNotEmpty()){
//                    countryAdapter.setNewData(it)
//                }
//                else{
//                    Snackbar.make(mView, "Empty", Snackbar.LENGTH_LONG)
//                }
//            },
//            onFailure = {
//                Snackbar.make(mView, it, Snackbar.LENGTH_LONG)
//            }
//        )





//        mTourModel.getAllTours(onError = {
//            Log.e("error", it)
//        }).observe(this, Observer {
//            if (it.isNotEmpty()){
//                tourAdapter.setNewData(it.toMutableList())
//            }
//        })
//
//        mTourModel.getAllCountries(onError = {
//            Log.e("error", it)
//        }).observe(this, Observer {
//            if (it.isNotEmpty()){
//                countryAdapter.setNewData(it.toMutableList())
//            }
//        })





    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.dispose()
    }




}
