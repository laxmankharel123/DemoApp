package com.example.demoapp.LoginBoardActivity

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demoapp.View.MainActivity
import com.example.demoapp.R

import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.emailId
import kotlinx.android.synthetic.main.activity_sign_in.passWord


class SignInActivity : Activity() {
    // Email, password edittext
    var txtUsername: EditText? = null
    var txtPassword: EditText? = null

    // login button
    var btnLogin: Button? = null


    // Session Manager Class
    var session: SessionManager? = null
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        // Session Manager
        session = SessionManager(applicationContext)


        txtUsername = findViewById<View>(R.id.emailId) as EditText
        txtPassword = findViewById<View>(R.id.passWord) as EditText


        loginTab.setOnClickListener {
            val i = Intent(applicationContext, LoginModelUi::class.java)
            startActivity(i)
            finish()
        }

        signUpNOW.setOnClickListener {
            val i = Intent(applicationContext, LoginModelUi::class.java)
            startActivity(i)
            finish()
        }

            btnLogin = findViewById<View>(R.id.login) as Button

        btnLogin!!.setOnClickListener {
            val user = session!!.userDetails
            val username = txtUsername!!.text.toString()
            val password = txtPassword!!.text.toString()
            val email = user[SessionManager.KEY_Email]
            val password1 = user[SessionManager.KEY_Password]
            if (username.trim().length > 0 && password.trim().length > 0) {
                if (username.equals(email) && password.equals(password1)) {
                    session!!.createLoginSession("Android Hive", "anroidhive@gmail.com")
                    val i = Intent(applicationContext, MainActivity::class.java)
                    startActivity(i)
                    finish()
                } else {
                    Toast.makeText(this, "User email or password is incorrect.", Toast.LENGTH_SHORT)
                        .show()
                }
            }
            else {
                    Toast.makeText(
                        this,
                        "Please enter username and password.",
                        android.widget.Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }

        }
    override fun onBackPressed() {
        finish()
    }
    }



