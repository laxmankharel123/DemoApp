package com.example.demoapp.LoginBoardActivity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demoapp.MovieBoard.MovieBoardActivity
import com.example.demoapp.R
import kotlinx.android.synthetic.main.activity_login_model_ui.*

class LoginModelUi : AppCompatActivity() {

    var sessionManager:SessionManager? = null

    private val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    private val passwordPattern = "(?=^.{8,}\$)(?=.*\\d)(?=.*[!@#\$%^&*]+)(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*\$"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_model_ui)


        loginTabBarView.setNavigationOnClickListener {
            val intent = Intent(this, MovieBoardActivity::class.java)
            startActivity(intent)
            finish()
        }

        signIn.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }

         sessionManager = SessionManager(this)

        register.setOnClickListener {
             val emailId = emailId1.text.toString()
            val password = passWord1.text.toString()
            if ((emailId == ""  || password == "")) {
                Toast.makeText(this, "Please insert email Id and password.", Toast.LENGTH_SHORT).show()
            }
           else if((emailId.matches(emailPattern.toRegex())) && (password.matches(passwordPattern.toRegex())) )
            {
                sessionManager!!.createLoginSession(emailId, password)
                Toast.makeText(this,"Registered Successfully.",Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignInActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this, "Please insert Valid email Id and password.", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
