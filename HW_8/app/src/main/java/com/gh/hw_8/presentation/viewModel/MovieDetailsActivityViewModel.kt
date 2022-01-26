package com.gh.hw_8.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.domain.models.ActorDetails
import com.gh.hw_8.domain.usecase.FavoriteMoviesUseCase
import com.gh.hw_8.domain.usecase.LoadListActorUseCase
import kotlinx.coroutines.launch

class MovieDetailsActivityViewModel(
    private val loadListActorUseCase: LoadListActorUseCase,
    private val favoriteMoviesUseCase: FavoriteMoviesUseCase,
) : ViewModel() {

    lateinit var moviesDetail: LiveData<List<ActorDetails>>

    fun loadMovieDetail(id: Int) {
        viewModelScope.launch {
            moviesDetail = loadListActorUseCase.execute(id)
        }
    }

    fun addMovieInDataBase(favoriteMovie: FavoriteMovie) {
        viewModelScope.launch {
            favoriteMoviesUseCase.addMovieInDataBase(favoriteMovie)
        }
    }
}