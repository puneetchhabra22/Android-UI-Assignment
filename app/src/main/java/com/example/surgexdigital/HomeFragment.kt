package com.example.surgexdigital

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment

class HomeFragment : Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val jobCardView = view.findViewById<CardView>(R.id.cardView3)
        jobCardView.setOnClickListener {
            val fragmentManager = requireFragmentManager()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout4Fragment,JobOfferFragment())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        val jobCardViewMain = view.findViewById<CardView>(R.id.jobCardView)
        jobCardViewMain.setOnClickListener {
            val fragmentManager = requireFragmentManager()
            val transaction = fragmentManager.beginTransaction()
            transaction.replace(R.id.frameLayout4Fragment,JobOfferFragment())
            transaction.commit()
        }

        val offerDetail = view.findViewById<CardView>(R.id.placementOfferCardView)
        offerDetail.setOnClickListener {
            val intent = Intent(context,OfferDetails::class.java)
            startActivity(intent)
        }
    }
}

