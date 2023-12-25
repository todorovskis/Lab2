package com.example.lab2.api

import com.example.lab2.models.Movie


class FakeApi private constructor() {
    private val movies: MutableList<Movie> = mutableListOf()

    init {
        addNewMovie(
            Movie(
                1,
                "Title1",
                "Description1",
                "Director1",
                listOf("Actor1", "Actor2")
            )
        )
        addNewMovie(
            Movie(
                2,
                "Title2",
                "Description2",
                "Director2",
                listOf("Actor2", "Actor5")
            )
        )
        addNewMovie(
            Movie(
                3,
                "Title3",
                "Description3",
                "Director3",
                listOf("Actor3", "Actor6")
            )
        )
        addNewMovie(
            Movie(
                4,
                "Title4",
                "Description4",
                "Director4",
                listOf("Actor4", "Actor7")
            )
        )
        addNewMovie(
            Movie(
                5,
                "Title5",
                "Description5",
                "Director5",
                listOf("Actor5", "Actor8")
            )
        )
        addNewMovie(
            Movie(
                6,
                "Title6",
                "Description6",
                "Director6",
                listOf("Actor6", "Actor9")
            )
        )
        addNewMovie(
            Movie(
                7,
                "Title7",
                "Description7",
                "Director7",
                listOf("Actor7", "Actor2")
            )
        )
        addNewMovie(
            Movie(
                8,
                "Title8",
                "Description8",
                "Director8",
                listOf("Actor8", "Actor1")
            )
        )
    }

    fun getAllMovies(): List<Movie> = movies.toList()

    fun addNewMovie(movie: Movie) {
        movies.add(movie)
    }

    companion object {
        @Volatile
        private var INSTANCE: FakeApi? = null

        @JvmStatic
        fun getFakeApi(): FakeApi {
            return INSTANCE ?: synchronized(this) {
                val instance = INSTANCE ?: FakeApi().also { INSTANCE = it }
                instance
            }
        }
    }
}

