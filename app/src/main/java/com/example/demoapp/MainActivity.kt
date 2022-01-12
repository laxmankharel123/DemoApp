package com.example.demoapp

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.LoginBoardActivity.SessionManager
import com.example.demoapp.Models.Movie
import com.example.demoapp.Network.MoviesRepository
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    private lateinit var popularMovies: RecyclerView
    private lateinit var popularMovieAdapter: MovieAdapter

    var session: SessionManager? = null
    private var backPressedTime:Long = 0
    lateinit var backToast:Toast



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        session = SessionManager(applicationContext)


        session!!.checkLogin()


        logOut.setOnClickListener {

            Toast.makeText(this,"User LogOut Successfully.",Toast.LENGTH_SHORT).show()
                session!!.logoutUser()
            
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
        finish()
    }
}

