package com.gh.hw_8.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gh.hw_8.databinding.ActivityMoviesFavoriteBinding

class FavoriteMovieActivity : AppCompatActivity() {

    lateinit var binding: ActivityMoviesFavoriteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMoviesFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}