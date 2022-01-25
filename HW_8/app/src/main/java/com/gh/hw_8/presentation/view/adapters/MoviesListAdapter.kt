package com.gh.hw_8.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gh.hw_8.R
import com.gh.hw_8.databinding.RecyclerViewMovieItemBinding
import com.gh.hw_8.domain.models.MovieDetails

interface ClickOnTheItem {
    fun itemPress(movieList: MovieDetails, movieId: Int)
}

class MoviesListAdapter(val clickOnTheItem: ClickOnTheItem) :
    ListAdapter<MovieDetails, MoviesListAdapter.ItemViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RecyclerViewMovieItemBinding.inflate(inflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(private val binding: RecyclerViewMovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: MovieDetails) {

            with(binding) {
                Glide.with(filmImage.context)
                    .load("https://www.themoviedb.org/t/p/w220_and_h330_face" + movie.movieImage)
                    .error(R.drawable.ic_not_image)
                    .into(filmImage)

                movieTitle.text = movie.movieName

                releaseDate.text = movie.movieReleaseDate

                filmItem.setOnClickListener {
                    clickOnTheItem.itemPress(movie, movie.movieId.toInt())
                }
            }
        }
    }

    class DiffCallBack : DiffUtil.ItemCallback<MovieDetails>() {

        override fun areItemsTheSame(oldItem: MovieDetails, newItem: MovieDetails): Boolean {
            return oldItem.movieId == newItem.movieId
        }

        override fun areContentsTheSame(oldItem: MovieDetails, newItem: MovieDetails): Boolean {
            return oldItem == newItem
        }
    }

}