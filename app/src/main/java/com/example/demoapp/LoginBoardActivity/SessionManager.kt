package com.example.demoapp.LoginBoardActivity


import java.util.HashMap

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor



class SessionManager(context: Context) {

    var pref: SharedPreferences

    var editor: Editor


    var context: Context


    var PRIVATE_MODE = 0


    companion object {

        private const val PREF_NAME = "AndroidHivePref"
        const val IS_LOGIN = "IsLoggedIn"
        const val KEY_Email = "email"
        const val KEY_Password = "password"
    }


    init {
        this@SessionManager.context = context
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }
    fun createLoginSession(userValue: String?, passwordValue: String?) {

        editor.putBoolean(IS_LOGIN, true)
        editor.putString(KEY_Email, userValue)
        editor.putString(KEY_Password, passwordValue)
        editor.commit()
    }


    fun checkLogin() {

        if (!isLoggedIn) {
            val intent = Intent(context, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            context.startActivity(intent)
        }
    }
    val userDetails: HashMap<String, String?>
        get() {
            val user = HashMap<String, String?>()
            user[KEY_Email] =
                pref.getString(KEY_Email, null)
            user[KEY_Password] =
                pref.getString(KEY_Password, null)
            pref.getBoolean(IS_LOGIN, false)

            return user
        }

    fun logoutUser() {
        editor.clear()
        editor.commit()
        val intent = Intent(context, SignInActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)
    }

    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)


}