package com.project.sepatoo.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.project.sepatoo.R

class DetailActivity : AppCompatActivity() {

    companion object {
        const val SHOES_IMAGE = "extra_image_resource"
        const val SHOES_IMAGE1 = "extra_image_resource1"
        const val SHOES_IMAGE2 = "extra_image_resource2"
        const val SHOES_IMAGE3 = "extra_image_resource3"
        const val SHOES_IMAGE4 = "extra_image_resource4"
        const val SHOES_IMAGE5 = "extra_image_resource5"
        const val SHOES_NAME = "extra_name"
        const val SHOES_BRAND = "extra_brand"
        const val SHOES_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bottom_sheet = findViewById<FrameLayout>(R.id.bottom_sheet)

        BottomSheetBehavior.from(bottom_sheet).apply {
            peekHeight = 600
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

        val btnBack = findViewById<ImageView>(R.id.iv_detail_back)
        btnBack.setOnClickListener{
            backClick()
        }

        val tvShoesName: TextView = findViewById(R.id.shoes_name)
        val tvShoesBrand: TextView = findViewById(R.id.shoes_brand)
        val tvShoesDetail: TextView = findViewById(R.id.shoes_detail)
        val imgShare: ImageView = findViewById(R.id.share_image)


        Glide.with(this)
            .load(intent.getIntExtra(SHOES_IMAGE, 0))
            .apply(RequestOptions().override(200, 450))
            .into(findViewById(R.id.shoes_image))

        Glide.with(this)
            .load(intent.getIntExtra(SHOES_IMAGE1, 0))
            .apply(RequestOptions().override(200, 450))
            .into(findViewById(R.id.shoes_image1))

        Glide.with(this)
            .load(intent.getIntExtra(SHOES_IMAGE2, 0))
            .apply(RequestOptions().override(200, 450))
            .into(findViewById(R.id.shoes_image2))

        Glide.with(this)
            .load(intent.getIntExtra(SHOES_IMAGE3, 0))
            .apply(RequestOptions().override(200, 450))
            .into(findViewById(R.id.shoes_image3))

        Glide.with(this)
            .load(intent.getIntExtra(SHOES_IMAGE4, 0))
            .apply(RequestOptions().override(200, 450))
            .into(findViewById(R.id.shoes_image4))

        Glide.with(this)
            .load(intent.getIntExtra(SHOES_IMAGE5, 0))
            .apply(RequestOptions().override(200, 450))
            .into(findViewById(R.id.shoes_image5))

        tvShoesName.text = intent.getStringExtra(SHOES_NAME)
        tvShoesBrand.text = intent.getStringExtra(SHOES_BRAND)
        tvShoesDetail.text = intent.getStringExtra(SHOES_DETAIL)

        val planetName = intent.getStringExtra(SHOES_NAME)

        imgShare.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.apply {
                putExtra(Intent.EXTRA_TEXT, "Hi My favorite planet is $planetName, What's yours?\n\n\n#FavoritePlanet")
            }
            startActivity(Intent.createChooser(intent, "Share Planet"))
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun backClick(){
        val intent = Intent(this, MainActivity::class.java).also {
            startActivity(it)
        }
        finish()
    }
}