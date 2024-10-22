package com.example.laba1

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    private lateinit var recyclerViewChats: RecyclerView
    private val TAG = "HomeActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate called")
        setContentView(R.layout.activity_home)

        recyclerViewChats = findViewById(R.id.recyclerViewChats)

        val fakeChats = listOf(
            Chat("Иван Иванов", "Привет, как ты?", "12:45", R.drawable.ic_profile_placeholder),
        )

        val adapter = ChatsAdapter(fakeChats)
        recyclerViewChats.adapter = adapter
        recyclerViewChats.layoutManager = LinearLayoutManager(this)
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