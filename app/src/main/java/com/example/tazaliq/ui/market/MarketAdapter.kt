package com.example.tazaliq.ui.market

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tazaliq.core.BaseAdapter
import com.example.tazaliq.core.extentions.inflate
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.data.model.Product

class MarketAdapter(private val itemResId: Int) :
    BaseAdapter<Product?, MarketAdapter.MarketViewHolder>(itemResId) {

    inner class MarketViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: Product?, position: Int) {
            itemView.apply {

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