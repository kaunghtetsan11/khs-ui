package com.khs.khs_ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khs.khs_ui.R
import com.khs.khs_ui.databinding.ItemRateBinding
import com.khs.khs_ui.model.RateItem

class RateAdapter : ListAdapter<RateItem, RateAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_rate, parent, false)
    ) {
        private val binding = ItemRateBinding.bind(itemView)

        fun bind(
            rate: RateItem?
        ) {
            with(binding) {
                this.rate = rate
                executePendingBindings()
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<RateItem>() {
            override fun areItemsTheSame(
                oldItem: RateItem,
                newItem: RateItem
            ): Boolean = oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: RateItem,
                newItem: RateItem
            ): Boolean = oldItem == newItem
        }
    }
}