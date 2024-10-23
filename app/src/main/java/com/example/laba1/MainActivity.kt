package com.example.laba1


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            navigateToOnboard()
        }
    }

    fun navigateToOnboard() {
        replaceFragment(OnboardFragment())
    }

    fun navigateToSignIn() {
        replaceFragment(SignInFragment())
    }

    fun navigateToSignUp(fragment: Fragment) {
        replaceFragment(SignUpFragment(), addToBackStack = true)
    }

    fun navigateToHome() {
        replaceFragment(HomeFragment())
    }

    private fun replaceFragment(fragment: Fragment, addToBackStack: Boolean = false) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            if (addToBackStack) {
                addToBackStack(null)
            }
            commit()
        }
    }
}
