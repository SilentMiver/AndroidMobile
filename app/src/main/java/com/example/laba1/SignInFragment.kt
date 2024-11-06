package com.example.laba1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.laba1.databinding.FragmentSignInBinding

class SignInFragment : Fragment() {
    private var _binding: FragmentSignInBinding? = null
    private val binding get() = _binding ?: throw RuntimeException()
    private val args: SignInFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Populate fields if user data exists
        args.user?.let { user ->
            binding.editEmailAddress.setText(user.email)
            binding.textUsername.text = "Welcome, ${user.username}"
        }

        binding.authButton.setOnClickListener {
            if (validateInput()) {
                findNavController().navigate(SignInFragmentDirections.actionSignInToHome())
            } else {
                binding.textError.text = "Invalid email or password"
                binding.textError.visibility = View.VISIBLE
            }
        }

        binding.signUpButton.setOnClickListener {
            val user = User(
                email = binding.editEmailAddress.text.toString()
            )
            val action = SignInFragmentDirections.actionSignInToSignUp(user)
            findNavController().navigate(action)
        }

        // Observe for result from SignUpFragment
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<User>("signUpResult")?.observe(
            viewLifecycleOwner
        ) { user ->
            binding.editEmailAddress.setText(user.email)
            binding.textUsername.text = "Welcome, ${user.username}"
        }
    }

    private fun validateInput(): Boolean {
        val email = binding.editEmailAddress.text.toString()
        val password = binding.editPassword.text.toString()
        return isValidEmail(email) && isValidPassword(password)
    }

    private fun isValidEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isValidPassword(password: String): Boolean {
        return password.isNotEmpty()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}