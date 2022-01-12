package com.example.demoapp.MovieBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.demoapp.LoginBoardActivity.LoginModelUi
import com.example.demoapp.LoginBoardActivity.SignInActivity
import com.example.demoapp.R
import kotlinx.android.synthetic.main.activity_movie_board.*


class MovieBoardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_board)

        btn_onboard_get_started.setOnClickListener{
            val intent = Intent(this, LoginModelUi::class.java)
            startActivity(intent)
            finish()
        }



        }


}
