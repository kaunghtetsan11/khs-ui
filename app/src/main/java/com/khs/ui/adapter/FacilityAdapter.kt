package com.khs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khs.ui.R
import com.khs.ui.databinding.ItemFacilityBinding
import com.khs.ui.model.FacilityItem


class FacilityAdapter : ListAdapter<FacilityItem, FacilityAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_facility, parent, false)
    ) {
        private val binding = ItemFacilityBinding.bind(itemView)

        fun bind(
            facility: FacilityItem?
        ) {
            with(binding) {
                this.facility = facility
                executePendingBindings()
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<FacilityItem>() {
            override fun areItemsTheSame(
                oldItem: FacilityItem,
                newItem: FacilityItem
            ): Boolean = oldItem.name == newItem.name

            override fun areContentsTheSame(
                oldItem: FacilityItem,
                newItem: FacilityItem
            ): Boolean = oldItem == newItem
        }
    }
}