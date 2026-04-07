package com.janlazaropardoprovapractica03

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val viewModel: ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        loginBehavior()
    }

    fun loginBehavior() {
        setContentView(R.layout.activity_login)

        val usernameEditText = findViewById<EditText>(R.id.etUsuari)
        val passwordEditText = findViewById<EditText>(R.id.etPassword)
        val loginButton = findViewById<Button>(R.id.btnLogin)

        loginButton.setOnClickListener {
            viewModel.login(usernameEditText.text.toString(), passwordEditText.text.toString())
        }

        viewModel.user.observe(this) {

            if (viewModel.user.value == null) {return@observe}

            reservationsBehavior()
        }
    }

    fun reservationsBehavior() {
        setContentView(R.layout.activity_reserves)
    }
}