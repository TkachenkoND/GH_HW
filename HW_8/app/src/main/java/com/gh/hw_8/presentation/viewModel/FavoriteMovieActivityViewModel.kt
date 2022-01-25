package com.gh.hw_8.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.domain.usecase.FavoriteMoviesUseCase
import kotlinx.coroutines.launch

class FavoriteMovieActivityViewModel(private val favoriteMoviesUseCase: FavoriteMoviesUseCase) :
    ViewModel() {

    lateinit var favoriteMovieList: LiveData<List<FavoriteMovie>>

    fun removeMovieFromDataBase(favoriteMovieId: Int) {
        viewModelScope.launch {
            favoriteMoviesUseCase.removeMovieFromDataBase(favoriteMovieId)
        }
    }

    fun loadFavoriteMovie() {
        favoriteMovieList = favoriteMoviesUseCase.fetchFavoriteMovies()
    }
}