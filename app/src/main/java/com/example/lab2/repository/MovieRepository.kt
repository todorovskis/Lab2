package com.example.lab2.repository

import com.example.lab2.api.FakeApi
import com.example.lab2.models.Movie

class MovieRepository(private val movieDbApi: FakeApi) {
    fun listMovies(): List<Movie> = movieDbApi.getAllMovies()

    fun getMovie(movieId: String): Movie? {
        return movieDbApi.getAllMovies().find { it.id.toString() == movieId }
    }

    fun addMovie(
        title: String,
        description: String,
        director: String,
        actors: List<String>
    ): List<Movie> {
        val movies = movieDbApi.getAllMovies()
        val newMovie = Movie(
            movies.size + 1,
            title,
            description,
            director,
            actors
        )

        movieDbApi.addNewMovie(newMovie)
        return movieDbApi.getAllMovies()
    }
}
