package com.example.lab2.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.lab2.models.Movie
import com.example.lab2.repository.MovieRepository

class MovieDetailViewModel(
    private val movieRepository: MovieRepository
) : ViewModel() {
    private val detailsForMovieLiveData = MutableLiveData<Movie>()

    fun getDetailsForMovieLiveData(): LiveData<Movie> = detailsForMovieLiveData

    fun listAllDetails(movieId: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movie = movieRepository.getMovie(movieId)
            detailsForMovieLiveData.postValue(movie)
        }
    }
}