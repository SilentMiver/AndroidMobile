package com.example.laba1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var authButton: Button
    private lateinit var signUpButton: Button
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var textError: TextView
    private lateinit var textUsername: TextView
    private val TAG = "SignInActivity"

    private val signUpLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            result.data?.let { intent ->
                // Handle String data
                val username = intent.getStringExtra("USERNAME") ?: ""
                val email = intent.getStringExtra("EMAIL") ?: ""

                // Handle Parcelable User object
                val user = intent.getParcelableExtra<User>("USER")

                // Display received data
                textUsername.text = "Welcome, ${user?.username ?: username}"
                editEmail.setText(user?.email ?: email)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_sign_in)

        authButton = findViewById(R.id.authButton)
        signUpButton = findViewById(R.id.signUpButton)
        editEmail = findViewById(R.id.editEmailAddress)
        editPassword = findViewById(R.id.editPassword)
        textError = findViewById(R.id.textError)
        textUsername = findViewById(R.id.textUsername)

        authButton.setOnClickListener(this)
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpLauncher.launch(intent)
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