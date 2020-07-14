package com.example.assignment5.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

import com.example.assignment5.R
import com.example.assignment5.adapters.TourImagesAdapter
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO
import com.example.assignment5.mvp.presenters.DetailsPresenter
import com.example.assignment5.mvp.presenters.DetailsPresenterImpl
import com.example.assignment5.mvp.views.DetailsView
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment(name: String) : Fragment() , DetailsView{


    private lateinit var mPresenter: DetailsPresenter
    lateinit var mView: View
    lateinit var mAdapter: TourImagesAdapter
    val mName:String = name

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mView=view

        setUpPresenter()
        setUpRecyclerView()
        mPresenter.onTourDetailsUiReady(this, mName)

    }

    private fun setUpPresenter(){
        mPresenter=ViewModelProviders.of(this).get(DetailsPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecyclerView(){
        val layoutManager= LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvTourImages.layoutManager=layoutManager

        mAdapter= TourImagesAdapter()
        rvTourImages.adapter=mAdapter
    }

    override fun displayTourDetails(tour: TourVO) {
        Glide.with(mView.context).load(tour.photos[0]).into(ivTourImage)
        tvTourName.text=tour.name
        tvLocation.text=tour.location
        ratingBar.rating=tour.averageRating.toFloat()
        tvRating.text=tour.averageRating.toString()

        tvBooking.text=tour.scoresAndReviews[0].name
        tvBookingRating.text=tour.scoresAndReviews[0].score.toString()+"/"+tour.scoresAndReviews[0].maxScore.toString()
        tvBookingReviews.text="Based on ${tour.scoresAndReviews[0].totalReviews.toString()} reviews"

        tvHotelOut.text=tour.scoresAndReviews[1].name
        tvHotelRating.text=tour.scoresAndReviews[1].score.toString()+"/"+tour.scoresAndReviews[0].maxScore.toString()
        tvHotelReviews.text="Based on ${tour.scoresAndReviews[1].totalReviews.toString()} reviews"

        tvDescription.text=tour.description

        mAdapter.setTourImages(tour.photos)
    }

    override fun displayCountryDetails(country: CountryVO) {
        Glide.with(mView.context).load(country.photos[0]).into(ivTourImage)
        tvTourName.text=country.name
        tvLocation.text=country.location
        ratingBar.rating=country.averageRating.toFloat()
        tvRating.text=country.averageRating.toString()

        tvBooking.text=country.scoresAndReviews[0].name
        tvBookingRating.text=country.scoresAndReviews[0].score.toString()+"/"+country.scoresAndReviews[0].maxScore.toString()
        tvBookingReviews.text="Based on ${country.scoresAndReviews[0].totalReviews.toString()} reviews"

        tvHotelOut.text=country.scoresAndReviews[1].name
        tvHotelRating.text=country.scoresAndReviews[1].score.toString()+"/"+country.scoresAndReviews[0].maxScore.toString()
        tvHotelReviews.text="Based on ${country.scoresAndReviews[1].totalReviews.toString()} reviews"

        tvDescription.text=country.description

        mAdapter.setTourImages(country.photos)
    }



}
