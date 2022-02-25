package com.khs.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.khs.ui.R
import com.khs.ui.databinding.ItemRoomBinding
import com.khs.ui.model.RoomItem

class RoomAdapter : ListAdapter<RoomItem, RoomAdapter.ViewHolder>(COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(
        parent: ViewGroup
    ) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.item_room, parent, false)
    ) {
        private val binding = ItemRoomBinding.bind(itemView)

        fun bind(
            room: RoomItem?
        ) {
            with(binding) {
                this.room = room
                executePendingBindings()
            }
        }
    }

    companion object {
        val COMPARATOR = object : DiffUtil.ItemCallback<RoomItem>() {
            override fun areItemsTheSame(
                oldItem: RoomItem,
                newItem: RoomItem
            ): Boolean = oldItem.title == newItem.title

            override fun areContentsTheSame(
                oldItem: RoomItem,
                newItem: RoomItem
            ): Boolean = oldItem == newItem
        }
    }
}