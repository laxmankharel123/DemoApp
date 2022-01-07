package com.example.demoapp.Network


import com.example.demoapp.Models.GetMoviesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {

    @GET("search/movie")
        fun getPopularMovies(
            @Query("api_key")
            apiKey: String = "4f593a1326880ff31e844e8adafefeb8",
            @Query("query")
            man: String
    ): Call<GetMoviesResponse>
    }


    //  https://api.themoviedb.org/3/search/movie?api_key=4f593a1326880ff31e844e8adafefeb8&query=man//sWvxBXNtCOaGdtpKNLiOqmwb10N.jpg
