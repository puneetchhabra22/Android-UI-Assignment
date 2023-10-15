package com.example.surgexdigital

import android.app.Activity
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder

class ViewPagerAdapter(activity : FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return if(position == 0){
            OfferDetailsFragment()
        } else if(position == 1) {
            EligibilityFragment()
        } else {
            CompensationFragment()
        }
    }
}