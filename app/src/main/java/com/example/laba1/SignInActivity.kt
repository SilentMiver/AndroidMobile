package com.example.laba1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var authButton: Button
    lateinit var editEmail: EditText
    lateinit var editPassword: EditText
    lateinit var textError: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_in)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        authButton = findViewById(R.id.authButton)
        editEmail = findViewById(R.id.editEmailAddress)
        editPassword = findViewById(R.id.editPassword)
        textError = findViewById(R.id.textError)

        authButton.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()

        if (isValidEmail(email) && isValidPassword(password)) {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        } else {
            textError.text = "Invalid email or password"
            textError.visibility = View.VISIBLE
        }
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }
}
