package com.gh.hw_8.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gh.hw_8.R
import com.gh.hw_8.databinding.RecyclerViewActorItemBinding
import com.gh.hw_8.domain.models.ActorDetails

class ActorListAdapter :
    ListAdapter<ActorDetails, ActorListAdapter.ItemViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewActorItemBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(private val binding: RecyclerViewActorItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(actor: ActorDetails) {

            with(binding) {
                Glide.with(actorImage.context)
                    .load("https://www.themoviedb.org/t/p/w220_and_h330_face" + actor.actorImage)
                    .error(R.drawable.ic_not_image)
                    .into(actorImage)

                actorName.text = actor.actorName
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<ActorDetails>() {

        override fun areItemsTheSame(oldItem: ActorDetails, newItem: ActorDetails): Boolean {
            return oldItem.actorName == newItem.actorName
        }

        override fun areContentsTheSame(oldItem: ActorDetails, newItem: ActorDetails): Boolean {
            return oldItem == newItem
        }
    }

}