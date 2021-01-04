package com.example.tazaliq.ui.rating.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tazaliq.R
import com.example.tazaliq.data.model.RatingModel

class RatingAdapter : RecyclerView.Adapter<RatingViewHolder>() {

    private var models: List<RatingModel> = arrayListOf()

    fun setData(models: List<RatingModel>) {
        this.models = models
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RatingViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rating_item_view, parent, false)
        return RatingViewHolder(view)
    }

    override fun onBindViewHolder(holder: RatingViewHolder, position: Int) {
        return holder.populateModel(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }
}