package com.example.lab2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.lab2.models.Movie
import com.example.lab2.repository.MovieRepository

class MoviesViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val moviesLiveData = MutableLiveData<List<Movie>>()

    fun getMovieLiveData(): LiveData<List<Movie>> = moviesLiveData

    fun listAll() {
        viewModelScope.launch(Dispatchers.IO) {
            val movies = movieRepository.listMovies()

            moviesLiveData.postValue(movies)
        }
    }
}