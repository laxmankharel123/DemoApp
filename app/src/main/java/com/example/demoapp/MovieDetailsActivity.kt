package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.demoapp.Models.Movie


class MovieDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)


        val bundle = intent.getBundleExtra("MovieBundle")
        val item = bundle?.getParcelable<Movie>("intent_PARCELABLE")

        val movieTitle = findViewById<TextView>(R.id.movieTitle)
        val movieDes = findViewById<TextView>(R.id.movieDescription)
        val movieDate = findViewById<TextView>(R.id.releaseDate)
        val posterImage = findViewById<ImageView>(R.id.imageDetails)

        movieTitle.text = item?.original_title
        movieDate.text = item?.release_date
        movieDes.text = item?.overview
        Glide.with(posterImage)
            .load(item?.poster_path)
            .into(posterImage)
    }
}







