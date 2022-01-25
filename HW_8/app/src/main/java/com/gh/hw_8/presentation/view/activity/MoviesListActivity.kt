package com.gh.hw_8.presentation.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gh.hw_8.databinding.ActivityMoviesListBinding

class MoviesListActivity: AppCompatActivity() {

    lateinit var binding: ActivityMoviesListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMoviesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}