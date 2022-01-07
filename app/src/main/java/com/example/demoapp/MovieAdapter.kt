package com.example.demoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.example.demoapp.Models.Movie

class MovieAdapter( private var movies: List<Movie>): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recycler_list_view, parent, false)
        return MovieViewHolder(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        holder.bind(movies[position])

    }

    fun updateMovies(movies: List<Movie>) {
        this.movies = movies
        notifyDataSetChanged()
    }

  inner  class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

      fun bind(movie: Movie) {

            val title: TextView = itemView.findViewById(R.id.original_title)
            val description: TextView = itemView.findViewById(R.id.overview)
            val releaseDate: TextView = itemView.findViewById(R.id.releaseDate)
            val posterImage: ImageView = itemView.findViewById(R.id.item_movie_poster)

          Glide.with(itemView)
              .load("https://image.tmdb.org/t/p/original${movie.poster_path}")
              .into(posterImage)

           title.text = movie.original_title
            description.text = movie.overview
            releaseDate.text = movie.release_date


        }
    }
}
