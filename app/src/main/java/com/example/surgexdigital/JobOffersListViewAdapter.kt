package com.example.surgexdigital

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class JobOffersListViewAdapter(
    context: Context?,
    val jobOffersArrayList: ArrayList<JobOffers>) : ArrayAdapter<JobOffers>(context!!, R.layout.joboffer_list_item, jobOffersArrayList
) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.joboffer_list_item, null)

        val jobPhoto = view.findViewById<ImageView>(R.id.jobPhoto)
        val jobTitle = view.findViewById<TextView>(R.id.jobTitle)
        val jobDesc = view.findViewById<TextView>(R.id.jobDescText)
        val jobStatus = view.findViewById<TextView>(R.id.jobStatus)
        val jobStatusColorImage = view.findViewById<ImageView>(R.id.jobStatusColorImage)

        jobTitle.text = jobOffersArrayList[position].jobTitle
        jobDesc.text = jobOffersArrayList[position].jobDescription
        jobStatus.text = jobOffersArrayList[position].status
        jobPhoto.setImageResource(jobOffersArrayList[position].jobPhoto)

        return view
    }
}
