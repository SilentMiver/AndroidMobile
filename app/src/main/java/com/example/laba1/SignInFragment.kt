package com.example.laba1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener

class SignInFragment : Fragment() {
    private lateinit var authButton: Button
    private lateinit var signUpButton: Button
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var textError: TextView
    private lateinit var textUsername: TextView
    private val TAG = "SignInFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView called")
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authButton = view.findViewById(R.id.authButton)
        signUpButton = view.findViewById(R.id.signUpButton)
        editEmail = view.findViewById(R.id.editEmailAddress)
        editPassword = view.findViewById(R.id.editPassword)
        textError = view.findViewById(R.id.textError)
        textUsername = view.findViewById(R.id.textUsername)

        setUpListeners()
        setUpFragmentResultListener()
    }

    private fun setUpListeners() {
        authButton.setOnClickListener {
            if (validateInput()) {
                (activity as? MainActivity)?.navigateToHome()
            } else {
                textError.text = "Invalid email or password"
                textError.visibility = View.VISIBLE
            }
        }

        signUpButton.setOnClickListener {
            (activity as? MainActivity)?.navigateToSignUp(this)
        }
    }

    private fun setUpFragmentResultListener() {
        setFragmentResultListener("signUpResult") { _, bundle ->
            val user = bundle.getParcelable<User>("USER")
            user?.let {
                textUsername.text = "Welcome, ${it.username}"
                editEmail.setText(it.email)
            }
        }
    }

    private fun validateInput(): Boolean {
        val email = editEmail.text.toString()
        val password = editPassword.text.toString()
        return isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }
}