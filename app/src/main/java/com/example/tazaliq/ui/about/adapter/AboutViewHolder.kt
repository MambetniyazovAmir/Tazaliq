package com.example.tazaliq.ui.about.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tazaliq.data.model.AboutModel
import kotlinx.android.synthetic.main.about_item_view.view.*

class AboutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    fun populateModel(model: AboutModel) {
        itemView.apply {
            title_text.text = model.title
            description_text.text = model.description
        }
    }

}