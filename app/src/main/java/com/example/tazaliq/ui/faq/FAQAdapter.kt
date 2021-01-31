package com.example.tazaliq.ui.faq

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tazaliq.R
import com.example.tazaliq.core.BaseAdapter
import com.example.tazaliq.core.extentions.inflate
import com.example.tazaliq.core.extentions.onClick
import com.example.tazaliq.core.extentions.visibility
import com.example.tazaliq.data.model.FAQ
import kotlinx.android.synthetic.main.item_faq.view.*

class FAQAdapter(private val itemResId: Int) : BaseAdapter<FAQ?, FAQAdapter.FAQViewHolder>(itemResId) {

    inner class FAQViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun populateModel(model: FAQ?, position: Int) {
            itemView.apply {
                tvQuestion.text = model?.question
                tvAnswer.text = model?.answer
                if (model?.isOpened == true) {
                    icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_up_24)
                    tvAnswer.visibility(true)
                } else {
                    icon.setImageResource(R.drawable.ic_baseline_keyboard_arrow_down_24)
                    tvAnswer.visibility(false)
                }
            }
            itemView.onClick {
                model?.let { faq ->
                    faq.isOpened = !faq.isOpened
                    notifyItemChanged(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FAQViewHolder(parent.inflate(itemResId))

    override fun onBindViewHolder(holder: FAQViewHolder, position: Int) {
        holder.populateModel(models[position], position)
    }
}