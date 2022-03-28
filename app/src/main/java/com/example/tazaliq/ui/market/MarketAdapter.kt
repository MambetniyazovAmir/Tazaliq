package com.example.tazaliq.ui.market

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tazaliq.core.BaseAdapter
import com.example.tazaliq.core.extentions.inflate
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.data.model.Product
import kotlinx.android.synthetic.main.product_row_item.view.*

class MarketAdapter(private val itemResId: Int) :
    BaseAdapter<Product?, MarketAdapter.MarketViewHolder>(itemResId) {

    inner class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Product?, position: Int) {
            itemView.apply {
                product_name.text = model?.name
                product_price.text = model?.price
                Glide.with(itemView.context).load(model?.photo).into(product_image)
            }
            itemView.onClick {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MarketViewHolder(parent.inflate(itemResId))


    override fun onBindViewHolder(holder: MarketAdapter.MarketViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

}