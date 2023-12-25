package com.example.lab2.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.R

class ActorAdapter(
    private val actors: List<String>
) : RecyclerView.Adapter<ActorAdapter.ActorsViewHolder>() {

    inner class ActorsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var movieActor: TextView = view.findViewById(R.id.movie_actor)

        fun bind(actor: String) {
            movieActor.text = actor
        }
    }

    // inflates the layout
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ActorsViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.all_actors_layout, parent, false)
        return ActorsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ActorsViewHolder, position: Int) {
        holder.bind(actors[position])
    }

    // only returns count so we know what position we are at
    override fun getItemCount(): Int = actors.size

}