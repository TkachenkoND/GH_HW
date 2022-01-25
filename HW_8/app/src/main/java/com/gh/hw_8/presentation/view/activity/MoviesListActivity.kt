package com.gh.hw_8.presentation.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gh.hw_8.databinding.ActivityMoviesListBinding
import com.gh.hw_8.domain.models.MovieDetails
import com.gh.hw_8.presentation.view.adapters.ClickOnTheItem
import com.gh.hw_8.presentation.view.adapters.MoviesListAdapter
import com.gh.hw_8.presentation.viewModel.MovieListActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesListActivity: AppCompatActivity(), ClickOnTheItem {

    lateinit var binding: ActivityMoviesListBinding

    private val viewModel by viewModel<MovieListActivityViewModel>()

    private val movieListAdapter = MoviesListAdapter(this as ClickOnTheItem)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initObserve()
    }

    private fun initAdapter() {
        binding.recyclerViewContainerFilms.apply {
            adapter = movieListAdapter
        }
    }

    private fun initObserve() {
        viewModel.loadMovieList()

        viewModel.moviesListLiveData.observeForever {
            movieListAdapter.submitList(it)
        }
    }

    override fun itemPress(movieList: MovieDetails, movieId: Int) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra("movieId", movieId)
        startActivity(intent)
    }
}