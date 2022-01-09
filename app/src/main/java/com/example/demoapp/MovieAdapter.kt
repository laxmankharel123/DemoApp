package com.example.demoapp



import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


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

        val movieModel = movies[position]
            Glide.with(holder.itemView.context)
                .load("https://image.tmdb.org/t/p/original${movieModel.poster_path}")
                .into(holder.posterImage)
            holder.title.text = movieModel.original_title
            holder.description.text = movieModel.overview
            holder.releaseDate.text = movieModel.release_date

            holder.itemView.setOnClickListener {
                val intent = Intent(holder.itemView.context, MovieDetailsActivity::class.java)
                val bundle = Bundle()
                bundle.putParcelable("intent_PARCELABLE", movieModel)
                intent.putExtra("MovieBundle", bundle)
               holder.itemView.context.startActivity(intent)
            }
        }

    fun updateMovies(movies: List<Movie>) {
            this.movies = movies
            notifyDataSetChanged()
        }


        class MovieViewHolder(itemView: View ) : RecyclerView.ViewHolder(itemView) {
                val title: TextView = itemView.findViewById(R.id.original_title)
                val description: TextView = itemView.findViewById(R.id.overview)
                val releaseDate: TextView = itemView.findViewById(R.id.releaseDate)
                val posterImage: ImageView = itemView.findViewById(R.id.item_movie_poster)



        }

}













