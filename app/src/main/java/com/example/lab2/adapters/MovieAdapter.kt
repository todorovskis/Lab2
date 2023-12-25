package com.example.lab2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R
import com.example.lab2.models.Movie

class MovieAdapter(
    private val onClickListener: OnClickListener
) : RecyclerView.Adapter<MovieAdapter.MoviesViewHolder>() {

    private val movies: MutableList<Movie> = mutableListOf()

    inner class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieId: TextView = itemView.findViewById(R.id.movie_id)
        private val movieTitle: TextView = itemView.findViewById(R.id.movie_title)
        private val movieDirector: TextView = itemView.findViewById(R.id.movie_director)

        fun bind(movie: Movie, onClickListener: OnClickListener) {
            movieId.text = movie.id.toString()
            movieTitle.text = movie.title
            movieDirector.text = movie.director

            itemView.setOnClickListener {
                onClickListener.onClickItem(movie.id.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.all_movies_layout, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(movies[position], onClickListener)
    }

    override fun getItemCount(): Int = movies.size

    fun updateMovies(newMovies: List<Movie>) {
        movies.clear()
        movies.addAll(newMovies)
        notifyDataSetChanged()
    }

    fun interface OnClickListener {
        fun onClickItem(movieId: String)
    }
}
