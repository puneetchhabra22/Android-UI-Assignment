package com.example.surgexdigital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.surgexdigital.databinding.ActivityPhoneNumberBinding

class PhoneNumberActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone_number)

        val btnGetOTP = findViewById<Button>(R.id.btnGetOTP)

        btnGetOTP.setOnClickListener {
            val otpIntent = Intent(this,OTPActivity::class.java)
            startActivity(otpIntent)
        }
    }
}