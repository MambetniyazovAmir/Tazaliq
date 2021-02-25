package com.example.tazaliq.ui.rating.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tazaliq.core.extentions.inflate
import com.example.tazaliq.data.model.RatingModel
import com.example.tazaliq.data.model.User
import kotlinx.android.synthetic.main.rating_item_view.view.*

class RatingAdapter(private val itemResId: Int) :
    com.example.tazaliq.core.BaseAdapter<User?, RatingAdapter.RatingViewHolder>(itemResId) {

    inner class RatingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: User?, position: Int) {
            itemView.apply {
                title.text = model?.name
                description.text = model?.about
                Glide.with(this).load(model?.imageUrl).centerCrop().into(imgAvatar)
                tvQuantity.text = model?.quantity.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder =
        RatingViewHolder(parent.inflate(itemResId))

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }

}