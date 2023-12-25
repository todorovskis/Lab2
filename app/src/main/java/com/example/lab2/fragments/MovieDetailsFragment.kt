package com.example.lab2.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lab2.R
import com.example.lab2.adapters.ActorAdapter
import com.example.lab2.databinding.MovieDetailsFragmentBinding
import com.example.lab2.viewmodel.MovieDetailViewModel

class MovieDetailsFragment : Fragment(R.layout.movie_details_fragment) {
    private var _binding: MovieDetailsFragmentBinding? = null
    private val binding get() = _binding!!
    private val movieDetailsViewModel: MovieDetailViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = MovieDetailsFragmentBinding.bind(view)

        movieDetailsViewModel.getDetailsForMovieLiveData().observe(viewLifecycleOwner) {
            binding.movieIdLabel.text = it.id.toString()
            binding.movieTitleLabel.text = it.title
            binding.movieDescriptionLabel.text = it.description
            binding.movieDirectorLabel.text = it.director
            binding.movieActorsLabel.adapter = ActorAdapter(it.actors)
        }
    }
}