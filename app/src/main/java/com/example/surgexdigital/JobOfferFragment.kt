package com.example.surgexdigital

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.View
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.view.isEmpty
import androidx.fragment.app.Fragment

class JobOfferFragment : Fragment(R.layout.fragment_job_offer_screen) {
    lateinit var jobsArrayList : ArrayList<JobOffers>
    @SuppressLint("ResourceType")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val tvAll = view.findViewById<TextView>(R.id.tvAll)
        val tvTech = view.findViewById<TextView>(R.id.tvTech)
        val tvGovt = view.findViewById<TextView>(R.id.tvGovt)
        val tvPrivate = view.findViewById<TextView>(R.id.tvPrivate)
        val tvOther = view.findViewById<TextView>(R.id.tvOther)

        tvAll.setBackgroundResource(R.drawable.textview_selected_bg)
        tvAll.setTextColor(Color.parseColor("#FFFFFF"))

        //placement offer card view click listener
        val offerDetail = view.findViewById<CardView>(R.id.placementOfferCardView)
        offerDetail.setOnClickListener {
            val intent = Intent(context,OfferDetails::class.java)
            startActivity(intent)
        }

        //underlining See all text
        val tvSeeAll = view.findViewById<TextView>(R.id.tvSeeAll)

        val mSpannableString = SpannableString(tvSeeAll.text)

        // Setting underline style from
        // position 0 till length of
        // the spannable string
        mSpannableString.setSpan(UnderlineSpan(), 0, mSpannableString.length, 0)

        // Displaying this spannable
        // string in TextView
        tvSeeAll.text = mSpannableString

        //List
        val jobListView = view.findViewById<ListView>(R.id.jobListView)

        val jobTitles = arrayListOf<String>("Android Developer","Graphic Designer","UI/UX Designer")
        val jobDescriptions = arrayListOf<String>("Surgex Digital is looking for Android Interns","Plesant Pixels is hiring graphic designers","Surgex Digital is hiring UI/UX designer")
        val jobPhotos = arrayListOf<Int>(R.drawable.surgex_logo,R.drawable.plesant_logo,R.drawable.surgex_logo)
        val jobStatus = arrayListOf<String>("Active","Active","Active")
        val isActive = arrayListOf<Boolean>(true,true,true)
        val jobCategory = arrayListOf<String>("Tech","Other","Other")

        jobsArrayList = ArrayList()

        for(i in jobTitles.indices){
            val jobOffer = JobOffers(jobTitles[i],jobDescriptions[i],jobStatus[i],isActive[i],jobPhotos[i],jobCategory[i])
            jobsArrayList.add(jobOffer)
        }

        //We have the job Offers in jobsArrayList
        jobListView.adapter = JobOffersListViewAdapter(context,jobsArrayList)

        //Filter Jobs
        tvAll.setOnClickListener {
            clearOtherButtons()
            tvAll.setBackgroundResource(R.drawable.textview_selected_bg)
            tvAll.setTextColor(Color.parseColor("#FFFFFF"))
            jobListView.adapter = JobOffersListViewAdapter(context,jobsArrayList)
            if(jobListView.adapter.isEmpty){
                Toast.makeText(context,"No relevant Jobs",Toast.LENGTH_SHORT).show()
            }
        }
        tvTech.setOnClickListener {
            clearOtherButtons()
            tvTech.setBackgroundResource(R.drawable.textview_selected_bg)
            tvTech.setTextColor(Color.parseColor("#FFFFFF"))
            val filteredArrayList : ArrayList<JobOffers> = filter(jobsArrayList,"Tech")
            jobListView.adapter = JobOffersListViewAdapter(context,filteredArrayList)
            if(jobListView.adapter.isEmpty()){
                Toast.makeText(context,"No relevant Jobs",Toast.LENGTH_SHORT).show()
            }
        }
        tvGovt.setOnClickListener {
            clearOtherButtons()
            tvGovt.setBackgroundResource(R.drawable.textview_selected_bg)
            tvGovt.setTextColor(Color.parseColor("#FFFFFF"))
            val filteredArrayList : ArrayList<JobOffers> = filter(jobsArrayList,"Govt")
            jobListView.adapter = JobOffersListViewAdapter(context,filteredArrayList)
            if(jobListView.adapter.isEmpty()){
                Toast.makeText(context,"No relevant Jobs",Toast.LENGTH_SHORT).show()
            }
        }
        tvPrivate.setOnClickListener {
            clearOtherButtons()
            tvPrivate.setBackgroundResource(R.drawable.textview_selected_bg)
            tvPrivate.setTextColor(Color.parseColor("#FFFFFF"))
            val filteredArrayList : ArrayList<JobOffers> = filter(jobsArrayList,"Private")
            jobListView.adapter = JobOffersListViewAdapter(context,filteredArrayList)
            if(jobListView.adapter.isEmpty()){
                Toast.makeText(context,"No relevant Jobs",Toast.LENGTH_SHORT).show()
            }
        }
        tvOther.setOnClickListener {
            clearOtherButtons()
            tvOther.setBackgroundResource(R.drawable.textview_selected_bg)
            tvOther.setTextColor(Color.parseColor("#FFFFFF"))
            val filteredArrayList : ArrayList<JobOffers> = filter(jobsArrayList,"Other")
            jobListView.adapter = JobOffersListViewAdapter(context,filteredArrayList)
            if(jobListView.adapter.isEmpty()){
                Toast.makeText(context,"No relevant Jobs",Toast.LENGTH_SHORT).show()
            }
        }

        jobListView.setOnItemClickListener{ parent, view, position, id ->
            val intent = Intent(context,OfferDetails::class.java)
            startActivity(intent)
        }
    }

    private fun filter(jobsArrayList : ArrayList<JobOffers>,jobCategory: String): ArrayList<JobOffers> {
        var filteredJobOffers : ArrayList<JobOffers> = ArrayList()
        for (i in jobsArrayList.indices){
            if(jobsArrayList[i].jobCategory == jobCategory){
                filteredJobOffers.add(jobsArrayList[i])
            }
        }
        return filteredJobOffers
    }

    private fun clearOtherButtons() {
        val tvAll = view?.findViewById<TextView>(R.id.tvAll)
        val tvTech = view?.findViewById<TextView>(R.id.tvTech)
        val tvGovt = view?.findViewById<TextView>(R.id.tvGovt)
        val tvPrivate = view?.findViewById<TextView>(R.id.tvPrivate)
        val tvOther = view?.findViewById<TextView>(R.id.tvOther)

        tvAll?.apply {
            setTextColor(Color.parseColor("#000000"))
            setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        tvTech?.apply {
            setTextColor(Color.parseColor("#000000"))
            setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        tvGovt?.apply {
            setTextColor(Color.parseColor("#000000"))
            setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        tvPrivate?.apply {
            setTextColor(Color.parseColor("#000000"))
            setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
        tvOther?.apply {
            setTextColor(Color.parseColor("#000000"))
            setBackgroundColor(Color.parseColor("#FFFFFF"))
        }
    }
}