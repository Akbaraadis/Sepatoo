package com.project.sepatoo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.project.sepatoo.R
import com.project.sepatoo.data.Shoes
import com.project.sepatoo.ui.DetailActivity

class ListShoesAdapter(val listShoes: ArrayList<Shoes>, private val context: Context) : RecyclerView.Adapter<ListShoesAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvBrand: TextView = itemView.findViewById(R.id.tv_item_brand)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_row_shoes, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val shoes = listShoes[position]
        Glide.with(holder.itemView.context)
            .load(shoes.photo)
            .apply(RequestOptions().override(120, 160))
            .into(holder.imgPhoto)
        holder.tvName.text = shoes.name
        holder.tvBrand.text = shoes.brand
        holder.tvDetail.text = shoes.detail

        holder.itemView.setOnClickListener {
            val intentShoes = Intent(context, DetailActivity::class.java)

            intentShoes.apply {
                putExtra(DetailActivity.SHOES_IMAGE, shoes.photo)
                putExtra(DetailActivity.SHOES_NAME, shoes.name)
                putExtra(DetailActivity.SHOES_BRAND, shoes.brand)
                putExtra(DetailActivity.SHOES_DETAIL, shoes.detail)
                putExtra(DetailActivity.SHOES_IMAGE1, shoes.photo1)
                putExtra(DetailActivity.SHOES_IMAGE2, shoes.photo2)
                putExtra(DetailActivity.SHOES_IMAGE3, shoes.photo3)
                putExtra(DetailActivity.SHOES_IMAGE4, shoes.photo4)
                putExtra(DetailActivity.SHOES_IMAGE5, shoes.photo5)
            }

            holder.itemView.context.startActivity(intentShoes)
        }
    }

    override fun getItemCount(): Int {
        return listShoes.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Shoes)
    }
}