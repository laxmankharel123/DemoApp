package com.example.demoapp.SplashScreen
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.demoapp.LoginBoardActivity.SessionManager
import com.example.demoapp.LoginBoardActivity.SignInActivity
import com.example.demoapp.MainActivity
import com.example.demoapp.MovieBoard.MovieBoardActivity
import com.example.demoapp.R

class SplashScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        handleDirection()

       // Handler().postDelayed({

         //   val intent = Intent(this, MovieBoardActivity::class.java)
         //   startActivity(intent)
         //   finish()
       // }, 1000) // 3000 is the delayed time in milliseconds.

    }

    private fun handleDirection(){
        var session:SessionManager? = null
        session = SessionManager(applicationContext)

        Handler().postDelayed({
            if (session!!.isLoggedIn.equals(true)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                this.finish()
            } else {
                val intent = Intent(this, MovieBoardActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }, 500)

    }

}



