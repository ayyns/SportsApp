package com.dicoding.core.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dicoding.core.R
import com.dicoding.core.databinding.ItemListTourismBinding
import com.dicoding.core.domain.model.Sports

class SportsAdapter : ListAdapter<Sports, SportsAdapter.ListViewHolder>(DIFF_CALLBACK) {

    var onItemClick: ((Sports) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            ItemListTourismBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
    }

    inner class ListViewHolder(private var binding: ItemListTourismBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Sports) {
            Glide.with(itemView.context)
                .load(data.image)
                .placeholder(R.drawable.image_placeholder)
                .into(binding.ivItemImage)
            binding.tvItemTitle.text = data.name
            binding.tvItemSubtitle.text = data.description
        }

        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(getItem(bindingAdapterPosition))
            }
        }
    }

    companion object {
        val DIFF_CALLBACK: DiffUtil.ItemCallback<Sports> =
            object : DiffUtil.ItemCallback<Sports>() {
                override fun areItemsTheSame(oldItem: Sports, newItem: Sports): Boolean {
                    return oldItem.tourismId == newItem.tourismId
                }

                override fun areContentsTheSame(oldItem: Sports, newItem: Sports): Boolean {
                    return oldItem == newItem
                }
            }
    }
}