package ru.skillbranch.devintensive.ui.profile

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle



class SplashActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, ProfileActivity::class.java)
        startActivity(intent)
        finish()
    }
}