package com.example.demoapp.LoginBoardActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demoapp.MovieBoard.MovieBoardActivity
import com.example.demoapp.R
import kotlinx.android.synthetic.main.activity_login_model_ui.*

class LoginModelUi : AppCompatActivity() {

    var sharedPreference:SharedPreference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_model_ui)


        signIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

        loginTabBarView.setNavigationOnClickListener {
            val intent = Intent(this, MovieBoardActivity::class.java)
            startActivity(intent)
            finish()
        }

        sharedPreference = SharedPreference(this)
        register.setOnClickListener {
             val emailId = emailId1.text.toString()
            val password = passWord1.text.toString()

            if (emailId == ""  || password == "") {
                Toast.makeText(this, "Please Enter Details.", Toast.LENGTH_SHORT).show()
            }
            else
            {
                sharedPreference!!.saveString("email_id",emailId)
                sharedPreference!!.saveString("password",password)
                Toast.makeText(this,"Registered Successfully.",Toast.LENGTH_SHORT).show()
                finish()
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()







            }
        }
    }
}
