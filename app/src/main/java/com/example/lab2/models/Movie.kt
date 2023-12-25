package com.example.lab2.models

data class Movie(
    var id: Int,
    var title: String,
    var description: String,
    var director: String,
    var actors: List<String>
)