package com.example.assignment5.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.assignment5.R
import com.example.assignment5.adapters.CountryAdapter
import com.example.assignment5.adapters.TourAdapter
import com.example.assignment5.data.models.TourModel
import com.example.assignment5.data.models.TourModelImpl
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.delegates.TourItemDelegate
import com.example.assignment5.mvp.presenters.MainPresenter
import com.example.assignment5.mvp.presenters.MainPresenterImpl
import com.example.assignment5.mvp.views.MainView
import com.google.android.material.snackbar.Snackbar
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), MainView {


    private lateinit var mPresenter: MainPresenter
    private lateinit var tourAdapter: TourAdapter
    private lateinit var countryAdapter: CountryAdapter
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

        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onUiReady(this)

    }



    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.dispose()
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(MainPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    override fun displayTours(tours: List<TourVO>) {
        tourAdapter.setNewData(tours.toMutableList())
    }

    override fun displayCountries(countries: List<CountryVO>) {
        countryAdapter.setNewData(countries.toMutableList())
    }

    override fun navigatetoTourDetails(name: String) {
        val transaction=fragmentManager?.beginTransaction()
        transaction?.replace(R.id.flContainer, DetailFragment(name))
        transaction?.addToBackStack(null)
        transaction?.commit()
    }



    private fun setUpRecyclerView() {

        val hLayoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvCountry.layoutManager = hLayoutManager
        countryAdapter = CountryAdapter(mPresenter)
        rvCountry.adapter = countryAdapter

        val vLayoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        rvPopularTours.layoutManager = vLayoutManager
        tourAdapter = TourAdapter(mPresenter)
        rvPopularTours.adapter = tourAdapter
    }

//    private fun requestData(){
//
//        mTourModel.getToursAndCountries()
//           .observeOn(AndroidSchedulers.mainThread())
//            .subscribe {
//            if (it.country.isNotEmpty()){
//                countryAdapter.setNewData(it.country.toMutableList())
//            }
//            if (it.tour.isNotEmpty()){
//                tourAdapter.setNewData(it.tour.toMutableList())
//            }
//        }.addTo(compositeDisposable)


}







