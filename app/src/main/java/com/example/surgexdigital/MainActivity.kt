package com.example.surgexdigital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({
            val welcomeActivityIntent = Intent(this,WelcomeActivity::class.java)
            startActivity(welcomeActivityIntent)
        },1200)
    }
}