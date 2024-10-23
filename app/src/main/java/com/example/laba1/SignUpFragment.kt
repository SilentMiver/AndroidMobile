package com.example.laba1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult

class SignUpFragment : Fragment() {
    private lateinit var editUsername: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var registerButton: Button
    private val TAG = "SignUpFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView called")
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        editUsername = view.findViewById(R.id.editUsername)
        editEmail = view.findViewById(R.id.editEmailAddress)
        editPassword = view.findViewById(R.id.editPassword)
        registerButton = view.findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val user = User(
                editUsername.text.toString(),
                editEmail.text.toString(),
                editPassword.text.toString()
            )

            setFragmentResult("signUpResult", bundleOf("USER" to user))
            parentFragmentManager.popBackStack()
        }
    }
}
