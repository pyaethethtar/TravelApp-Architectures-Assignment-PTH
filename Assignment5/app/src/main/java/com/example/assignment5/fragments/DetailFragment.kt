package com.example.assignment5.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide

import com.example.assignment5.R
import com.example.assignment5.adapters.TourImagesAdapter
import com.example.assignment5.data.models.TourModel
import com.example.assignment5.data.models.TourModelImpl
import com.example.assignment5.data.vos.CountryVO
import com.example.assignment5.data.vos.TourVO
import kotlinx.android.synthetic.main.fragment_detail.*

/**
 * A simple [Fragment] subclass.
 */
class DetailFragment(name: String) : Fragment() {

    lateinit var mTourModel: TourModel
    lateinit var mView: View
    lateinit var mAdapter: TourImagesAdapter
    var mName: String=name

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
        setUpRecyclerView()


        mTourModel=TourModelImpl(view.context)

        mTourModel.getAllToursByName(mName).observe(this, Observer {
            if (it!=null){ bindTourData(it) }
            })

        mTourModel.getAllCountryByName(mName)?.observe(this, Observer{
            if (it!=null){
                bindCountryData(it)
            }
        })

    }

    private fun setUpRecyclerView(){
        val layoutManager= LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false)
        rvTourImages.layoutManager=layoutManager

        mAdapter= TourImagesAdapter()
        rvTourImages.adapter=mAdapter
    }

    private fun bindTourData(data: TourVO){

        Glide.with(mView.context).load(data.photos[0]).into(ivTourImage)
        tvTourName.text=data.name
        tvLocation.text=data.location
        ratingBar.rating=data.averageRating.toFloat()
        tvRating.text=data.averageRating.toString()

        tvBooking.text=data.scoresAndReviews[0].name
        tvBookingRating.text=data.scoresAndReviews[0].score.toString()+"/"+data.scoresAndReviews[0].maxScore.toString()
        tvBookingReviews.text="Based on ${data.scoresAndReviews[0].totalReviews.toString()} reviews"

        tvHotelOut.text=data.scoresAndReviews[1].name
        tvHotelRating.text=data.scoresAndReviews[1].score.toString()+"/"+data.scoresAndReviews[0].maxScore.toString()
        tvHotelReviews.text="Based on ${data.scoresAndReviews[1].totalReviews.toString()} reviews"

        tvDescription.text=data.description

        mAdapter.setTourImages(data.photos)
    }

    private fun bindCountryData(data: CountryVO){

        Glide.with(mView.context).load(data.photos[0]).into(ivTourImage)
        tvTourName.text=data.name
        tvLocation.text=data.location
        ratingBar.rating=data.averageRating.toFloat()
        tvRating.text=data.averageRating.toString()

        tvBooking.text=data.scoresAndReviews[0].name
        tvBookingRating.text=data.scoresAndReviews[0].score.toString()+"/"+data.scoresAndReviews[0].maxScore.toString()
        tvBookingReviews.text="Based on ${data.scoresAndReviews[0].totalReviews.toString()} reviews"

        tvHotelOut.text=data.scoresAndReviews[1].name
        tvHotelRating.text=data.scoresAndReviews[1].score.toString()+"/"+data.scoresAndReviews[0].maxScore.toString()
        tvHotelReviews.text="Based on ${data.scoresAndReviews[1].totalReviews.toString()} reviews"

        tvDescription.text=data.description

        mAdapter.setTourImages(data.photos)
    }


}
