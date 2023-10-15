package com.example.surgexdigital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val guestTV = findViewById<TextView>(R.id.tvGuest)
        val btnPhoneNumber = findViewById<Button>(R.id.btnPhoneNumber)
        val btnOTP = findViewById<Button>(R.id.btnOTP)

        guestTV.setOnClickListener{
            val homeScreenIntent = Intent(this,HomeActivity::class.java)
            startActivity(homeScreenIntent)
        }

        btnPhoneNumber.setOnClickListener {
            val phoneNumberIntent = Intent(this,PhoneNumberActivity::class.java)
            startActivity(phoneNumberIntent)
        }

        btnOTP.setOnClickListener {
            val otpIntent = Intent(this,OTPActivity::class.java)
            startActivity(otpIntent)
        }
    }
}