package com.example.lab2.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.api.FakeApi
import com.example.lab2.repository.MovieRepository

class MovieListViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MovieRepository::class.java)
            .newInstance(
                MovieRepository(FakeApi.getFakeApi())
            )
    }
}