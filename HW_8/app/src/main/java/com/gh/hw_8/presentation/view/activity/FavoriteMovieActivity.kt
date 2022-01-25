package com.gh.hw_8.presentation.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.gh.hw_8.databinding.ActivityMoviesFavoriteBinding
import com.gh.hw_8.presentation.view.adapters.ClickOnBtnRemove
import com.gh.hw_8.presentation.view.adapters.FavoriteMovieListAdapter
import com.gh.hw_8.presentation.viewModel.FavoriteMovieActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteMovieActivity : AppCompatActivity(), ClickOnBtnRemove {

    lateinit var binding: ActivityMoviesFavoriteBinding

    private val viewModel by viewModel<FavoriteMovieActivityViewModel>()

    private val favoriteMovieListAdapter = FavoriteMovieListAdapter(this as ClickOnBtnRemove)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoviesFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initAdapter()
        initObserve()
    }

    private fun initAdapter() {
        binding.recyclerViewContainerFavoriteFilms.apply {
            adapter = favoriteMovieListAdapter
        }
    }

    private fun initObserve() {
        viewModel.loadFavoriteMovie()

        viewModel.favoriteMovieList.observeForever {
            favoriteMovieListAdapter.submitList(it)
        }
    }

    override fun btnPress(favoriteMovieId: Int) {
        viewModel.removeMovieFromDataBase(favoriteMovieId)

        Toast.makeText(applicationContext,
            "The movie has been removed from favorites",
            Toast.LENGTH_SHORT).show()
    }
}