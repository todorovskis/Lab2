package com.example.lab2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.lifecycle.ViewModelProvider
import com.example.lab2.R
import com.example.lab2.adapters.MovieAdapter
import com.example.lab2.databinding.MovieFragmentBinding
import com.example.lab2.viewmodel.MovieDetailViewModel
import com.example.lab2.viewmodel.MoviesViewModel
import com.example.lab2.viewmodel.MovieListViewModelFactory

class MovieFragment : Fragment(R.layout.movie_fragment) {
    private var _binding: MovieFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var movieListViewModel: MoviesViewModel

    private val movieDetailsViewModel: MovieDetailViewModel by activityViewModels {
        MovieListViewModelFactory(
            requireContext()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding =  MovieFragmentBinding.bind(view)

        val viewModelFactory = MovieListViewModelFactory(requireContext())
        movieListViewModel =
            ViewModelProvider(this, viewModelFactory)[MoviesViewModel::class.java]

        val clicker = MovieAdapter.OnClickListener { movieId ->
            movieDetailsViewModel.listAllDetails(movieId)

            parentFragmentManager.commit {
                replace(R.id.fragment_container_view, MovieDetailsFragment())
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        val adapter = MovieAdapter(clicker)
        binding.list.adapter = adapter

        movieListViewModel.getMovieLiveData().observe(viewLifecycleOwner) {
            adapter.updateMovies(it)
        }

        movieListViewModel.listAll()

        binding.buttonAdd.setOnClickListener {
            AddMovieDialogFragment().show(childFragmentManager, "add-movie-dialog")
        }
    }
}