package com.example.demoapp.LoginBoardActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.demoapp.MainActivity
import com.example.demoapp.R

import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_in.emailId
import kotlinx.android.synthetic.main.activity_sign_in.passWord

class SignInActivity : AppCompatActivity() {

    var sharedPreference:SharedPreference? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        loginTab.setNavigationOnClickListener {
            val intent = Intent(this, LoginModelUi::class.java)
            startActivity(intent)
            finish()

        }

            signUpNOW.setOnClickListener {
                val intent = Intent(this, LoginModelUi::class.java)
                startActivity(intent)
            }


            sharedPreference =SharedPreference(this)

                val loginStatus = sharedPreference!!.getPreferenceString("DemoApp1")
                if (loginStatus!=null){
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }

             login.setOnClickListener {
                    val emailId = emailId.text.toString()
                    val password = passWord.text.toString()

                    if(emailId == "" || password == ""){
                        Toast.makeText(this,"Please Enter Details.", Toast.LENGTH_SHORT).show()
                    }else {
                        val email = sharedPreference!!.getPreferenceString("email_id")
                        val password2 = sharedPreference!!.getPreferenceString("password")

                        if(email.equals(emailId) && password2.equals(password)){
                            sharedPreference!!.saveString("DemoApp1" ,"1")
                            val intent = Intent(this, MainActivity::class.java)
                            startActivity(intent)
                            finish()

                        } else {
                            Toast.makeText(this,"User Not Available Please Sign Up",Toast.LENGTH_SHORT).show()
                        }
                    }
                }






            }



        }






