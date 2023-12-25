package com.example.lab2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import com.example.lab2.api.FakeApi
import com.example.lab2.fragments.AddMovieDialogFragment
import com.example.lab2.fragments.MovieFragment
import com.example.lab2.repository.MovieRepository

class MainActivity : AppCompatActivity(), AddMovieDialogFragment.AddMovieDialogListener {
    private lateinit var repository: MovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                add(R.id.fragment_container_view, MovieFragment())
                setReorderingAllowed(true)
            }
        }

        this.repository = MovieRepository(FakeApi.getFakeApi())
    }

    override fun onDialogPositiveClick(
        title: String,
        description: String,
        director: String,
        actors: ArrayList<String>
    ) {
        repository.addMovie(title, description, director, actors)

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, MovieFragment())
            setReorderingAllowed(true)
        }
    }

    override fun onDialogNegativeClick(dialog: DialogFragment) {
        dialog.dismiss()
    }
}