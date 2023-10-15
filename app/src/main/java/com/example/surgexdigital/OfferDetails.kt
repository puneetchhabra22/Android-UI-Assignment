package com.example.surgexdigital

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toolbar
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OfferDetails : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_offer_details)

        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.setNavigationIcon(R.drawable.back_arrow)
        toolbar.setNavigationOnClickListener {
            this.finish()
        }

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val viewPagerAdapter = ViewPagerAdapter(this)
        viewPager.adapter = viewPagerAdapter

        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val tabNames = arrayOf("Details", "Eligibility", "Compensation")
        TabLayoutMediator(tabLayout,viewPager){ tab, position ->
            tab.text = tabNames[position]
        }.attach()

        val shareBtn = findViewById<AppCompatButton>(R.id.shareButton)
        val textMessage:String = "Hey, Check this out. I got an awesome android intern! \n https://www.linkedin.com/in/puneet-chhabra/"
        shareBtn.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, textMessage)
                type = "text/plain"
            }

            try {
                startActivity(sendIntent)
            } catch (e : Exception) {
            }
        }

    }
}