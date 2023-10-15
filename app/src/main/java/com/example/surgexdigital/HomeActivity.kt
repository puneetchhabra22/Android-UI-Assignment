package com.example.surgexdigital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuInflater
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavView)

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout4Fragment,HomeFragment())
            commit()
        }
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeItem -> replaceLayoutWithFrag(HomeFragment())
                R.id.collabItem -> replaceLayoutWithFrag(CollabFragment())
                R.id.referalItem -> replaceLayoutWithFrag(ReferalFragment())
                R.id.teamItem -> replaceLayoutWithFrag(MyTeamFragment())
            }
            true
        }
    }

     fun replaceLayoutWithFrag(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frameLayout4Fragment,fragment)
        transaction.commit()
    }
}