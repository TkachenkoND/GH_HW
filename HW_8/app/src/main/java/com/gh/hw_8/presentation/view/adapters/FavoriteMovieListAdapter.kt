package com.gh.hw_8.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gh.hw_8.R
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.databinding.RecyclerViewFavMovieItemBinding
import com.gh.hw_8.domain.models.MovieDetails

interface ClickOnBtnRemove {
    fun btnPress(favoriteMovieId: Int)
}

class FavoriteMovieListAdapter(private val clickOnBtnRemove: ClickOnBtnRemove) :
    ListAdapter<FavoriteMovie, FavoriteMovieListAdapter.ItemViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewFavMovieItemBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(private val binding: RecyclerViewFavMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(favMovie: FavoriteMovie) {

            with(binding) {
                Glide.with(filmImage.context)
                    .load("https://www.themoviedb.org/t/p/w220_and_h330_face" + favMovie.movieImage)
                    .error(R.drawable.ic_not_image)
                    .into(filmImage)

                movieTitle.text = favMovie.movieName

                btnDeleteMovieWithFav.setOnClickListener {
                    clickOnBtnRemove.btnPress(favMovie.movieId.toInt())
                }
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<FavoriteMovie>() {

        override fun areItemsTheSame(oldItem: FavoriteMovie, newItem: FavoriteMovie): Boolean {
            return oldItem.movieId == newItem.movieId
        }

        override fun areContentsTheSame(oldItem: FavoriteMovie, newItem: FavoriteMovie): Boolean {
            return oldItem == newItem
        }
    }
}