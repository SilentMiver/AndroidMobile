package com.example.laba1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    private lateinit var editUsername: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var registerButton: Button
    private val TAG = "SignUpActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_sign_up)

        editUsername = findViewById(R.id.editUsername)
        editEmail = findViewById(R.id.editEmailAddress)
        editPassword = findViewById(R.id.editPassword)
        registerButton = findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val username = editUsername.text.toString()
            val email = editEmail.text.toString()
            val password = editPassword.text.toString()

            val resultIntent = Intent().apply {
                // Method 1: Passing data as Strings
                putExtra("USERNAME", username)
                putExtra("EMAIL", email)

                // Method 2: Passing data as User object
                putExtra("USER", User(username, email, password))
            }

            setResult(RESULT_OK, resultIntent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy called")
    }
}