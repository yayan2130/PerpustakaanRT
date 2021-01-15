package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_thanks.*

class thanks : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thanks)

        val btn_Home = findViewById<Button>(R.id.btnhome)
        btn_Home.setOnClickListener{
            startActivity(
                Intent(this, MainActivity::class.java)
            )
            true
        }
    }
}