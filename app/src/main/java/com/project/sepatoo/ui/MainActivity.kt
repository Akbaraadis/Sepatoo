package com.project.sepatoo.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.sepatoo.R
import com.project.sepatoo.`object`.ShoesData
import com.project.sepatoo.adapter.ListShoesAdapter
import com.project.sepatoo.data.Shoes


class MainActivity : AppCompatActivity() {
    private lateinit var rvHeroes: RecyclerView
    private var list: ArrayList<Shoes> = arrayListOf()
    private var backButtonCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvHeroes = findViewById(R.id.rv_heroes)
        rvHeroes.setHasFixedSize(true)

        list.addAll(ShoesData.listData)
        showRecyclerCardView()

        val btnAbout = findViewById<ImageView>(R.id.iv_main_account)
        btnAbout.setOnClickListener{
            aboutClick()
        }
    }

    private fun showRecyclerCardView() {
        rvHeroes.layoutManager = LinearLayoutManager(this)
        val cardViewHeroAdapter = ListShoesAdapter(list, this)
        rvHeroes.adapter = cardViewHeroAdapter
    }

    private fun aboutClick() {
        val intent = Intent(this, AboutActivity::class.java).also {
            startActivity(it)
        }
    }

    override fun onBackPressed() {
        if (backButtonCount >= 1) {
            val intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            Toast.makeText(
                this,
                "Tekan tombol kembali sekali lagi untuk keluar.",
                Toast.LENGTH_SHORT
            ).show()
            backButtonCount++
        }
    }
}