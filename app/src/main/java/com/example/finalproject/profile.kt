package com.example.finalproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.activity_main.*

class profile : AppCompatActivity() {

    lateinit var toggle:ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile)
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home ->{
                    Toast.makeText(applicationContext, "Home", Toast.LENGTH_SHORT).show()
                    startActivity(
                            Intent(this, MainActivity::class.java)
                    )
                    true
                }
                R.id.AboutMe -> {
                    Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
                    startActivity(
                            Intent(this, profile::class.java)
                    )
                    true
                }
            }
            true
        }
    }
}