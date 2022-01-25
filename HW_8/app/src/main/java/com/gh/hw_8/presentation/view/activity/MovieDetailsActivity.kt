package com.gh.hw_8.presentation.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.gh.hw_8.R
import com.gh.hw_8.data.database.entity.FavoriteMovie
import com.gh.hw_8.databinding.ActivityMovieDetailsBinding
import com.gh.hw_8.presentation.view.adapters.ActorListAdapter
import com.gh.hw_8.presentation.viewModel.MovieDetailsActivityViewModel
import com.gh.hw_8.presentation.viewModel.MovieListActivityViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieDetailsActivity : AppCompatActivity() {

    lateinit var binding: ActivityMovieDetailsBinding

    private val detailVm by viewModel<MovieDetailsActivityViewModel>()
    private val listVm by viewModel<MovieListActivityViewModel>()

    private val listActorAdapter = ActorListAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setMovieDetail()

        initAdapter()
    }

    private fun initAdapter() {
        binding.recyclerViewContainerForActors.apply {
            adapter = listActorAdapter
        }
    }

    private fun setMovieDetail() {

        val movieId = getMovieId()

        listVm.loadMovieList()

        listVm.moviesListLiveData.observe(this, {
            with(binding) {
                filmName.text = it[movieId].movieName
                overview.text = it[movieId].overview
                releaseDate.text = it[movieId].movieReleaseDate
                rating.text = it[movieId].rating + "/10"

                Glide.with(filmImage.context)
                    .load("https://www.themoviedb.org/t/p/w220_and_h330_face" + it[movieId].movieImage)
                    .error(R.drawable.ic_not_image)
                    .into(filmImage)

                Glide.with(detailsBackground.context)
                    .load("https://www.themoviedb.org/t/p/w220_and_h330_face" + it[movieId].backdropPath)
                    .error(R.drawable.ic_not_image)
                    .into(detailsBackground)
            }

            clickOnBtnAddToFav(it[movieId].movieId, it[movieId].movieImage, it[movieId].movieName)

            setMovieActorList(it[movieId].movieId.toInt())
        })
    }

    private fun setMovieActorList(movieId: Int) {

        detailVm.loadMovieDetail(movieId)

        detailVm.moviesDetail.observe(this, {
            listActorAdapter.submitList(it)

        })
    }

    private fun clickOnBtnAddToFav(movieId: String, movieImage: String?, movieName: String) {
        binding.btnAddMovieToFav.setOnClickListener {
            detailVm.addMovieInDataBase(FavoriteMovie(movieId, movieImage, movieName))
        }

        Toast.makeText(applicationContext,
            "The movie has been added to favorites",
            Toast.LENGTH_SHORT).show()

    }

    private fun getMovieId() = intent.extras?.getInt("movieId")!!.toInt()
}