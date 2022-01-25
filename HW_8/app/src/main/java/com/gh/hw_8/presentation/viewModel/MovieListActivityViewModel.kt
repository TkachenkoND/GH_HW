package com.gh.hw_8.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gh.hw_8.domain.models.MovieDetails
import com.gh.hw_8.domain.usecase.LoadMovieDetailsUseCase
import kotlinx.coroutines.launch

class MovieListActivityViewModel(private val loadMovieDetailsUseCase: LoadMovieDetailsUseCase) :
    ViewModel() {

    lateinit var moviesListLiveData: LiveData<List<MovieDetails>>

    fun loadMovieList() {
        viewModelScope.launch {
            moviesListLiveData = loadMovieDetailsUseCase.execute()
        }
    }
}