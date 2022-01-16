package com.example.demoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.demoapp.Models.Movie
import com.example.demoapp.databinding.ActivityMovieDetailsBinding


class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val bundle = intent.getBundleExtra("MovieBundle")
        val item = bundle?.getParcelable<Movie>("intent_PARCELABLE")

      //  val movieTitle = findViewById<TextView>(R.id.movieTitle)
      //  val movieDes = findViewById<TextView>(R.id.movieDescription)
      //  val movieDate = findViewById<TextView>(R.id.releaseDate)
      //  val posterImage = findViewById<ImageView>(R.id.imageDetails)

       binding.movieTitle.text = item?.original_title
        binding.DateRelease.text = item?.release_date
       binding.movieDescription.text = item?.overview
        Glide.with(binding.imageDetails)
            .load("https://image.tmdb.org/t/p/original${item?.poster_path}")
            .into(binding.imageDetails)

    }
}







