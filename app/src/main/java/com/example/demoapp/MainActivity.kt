package com.example.demoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.demoapp.LoginBoardActivity.SharedPreference
import com.example.demoapp.LoginBoardActivity.SignInActivity
import com.example.demoapp.Models.Movie
import com.example.demoapp.Network.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMovieAdapter: MovieAdapter

    private var backPressedTime:Long = 0
    lateinit var backToast:Toast

    var sharedPreference: SharedPreference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreference = SharedPreference(this)
        logOut.setOnClickListener {
            sharedPreference!!.clearSharedPreference()
            Toast.makeText(this,"User LogOut Successfully.",Toast.LENGTH_SHORT).show()
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()

        }

        popularMovies = findViewById(R.id.rvMovie)
        popularMovies.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        popularMovieAdapter = MovieAdapter(listOf())
        popularMovies.adapter = popularMovieAdapter




        MoviesRepository.getPopularMovies(
            onSuccess = ::onPopularMoviesFetched,
            onError = ::onError
        )

    }

    private fun onPopularMoviesFetched(movies: List<Movie>) {
        popularMovieAdapter.updateMovies(movies)
    }

    private fun onError() {
        Toast.makeText(this, "Internet Connection Not Available", Toast.LENGTH_SHORT).show()
    }

    override fun onBackPressed() {
        backToast = Toast.makeText(this, "Press back again to leave the app.", Toast.LENGTH_LONG)
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast.cancel()
            super.onBackPressed()
            return
        } else {
            backToast.show()
            super.finish()
        }
        backPressedTime = System.currentTimeMillis()
    }
}

