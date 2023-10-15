package com.example.surgexdigital

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import com.example.surgexdigital.databinding.ActivityOtpBinding

class OTPActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)

        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            val homeScreenIntnt = Intent(this,HomeActivity::class.java)
            startActivity(homeScreenIntnt)
        }
    }
}