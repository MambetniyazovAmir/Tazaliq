package com.example.tazaliq.ui.about.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tazaliq.R
import com.example.tazaliq.data.model.AboutModel

class AboutAdapter: RecyclerView.Adapter<AboutViewHolder>() {

    private var models: List<AboutModel> = arrayListOf()

    fun setData(models: List<AboutModel>) {
        this.models = models
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AboutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.about_item_view, parent, false)
        return AboutViewHolder(view)
    }

    override fun onBindViewHolder(holder: AboutViewHolder, position: Int) {
        holder.populateModel(models[position])
    }

    override fun getItemCount(): Int {
        return models.size
    }

}