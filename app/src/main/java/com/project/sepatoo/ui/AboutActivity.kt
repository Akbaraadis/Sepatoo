package com.project.sepatoo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.project.sepatoo.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val btnBack = findViewById<ImageView>(R.id.iv_about_back)
        btnBack.setOnClickListener{
            backClick()
        }
    }

    private fun backClick(){
        val intent = Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}