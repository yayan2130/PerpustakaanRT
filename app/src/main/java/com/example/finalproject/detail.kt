package com.example.finalproject

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.detail_buku.*

class detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail_buku)
        var intentThatStartedThisActivity = getIntent()
        if (intentThatStartedThisActivity.hasExtra(Intent.EXTRA_TEXT)) {
            var imgB = intentThatStartedThisActivity.getIntExtra("gambar", 0)
            var nameB =intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TITLE)
            var deskB = intentThatStartedThisActivity.getStringExtra(Intent.EXTRA_TEMPLATE)
            image_detail.setImageResource(imgB)
            tv_name_detail.text = nameB
            sinopsis.text = deskB
        }
        val btn_Thanks = findViewById<Button>(R.id.btnNext)
        btn_Thanks.setOnClickListener{
            startActivity(
                Intent(this, thanks::class.java)
            )
            true
        }
    }
}