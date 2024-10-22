package com.example.laba1

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {
    lateinit var recyclerViewChats: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        recyclerViewChats = findViewById(R.id.recyclerViewChats)

        val fakeChats = listOf(
            Chat("Иван Иванов", "\t Привет, как ты?", "12:45", R.drawable.ic_profile_placeholder),
                    )

        val adapter = ChatsAdapter(fakeChats)
        recyclerViewChats.adapter = adapter
        recyclerViewChats.layoutManager = LinearLayoutManager(this)
    }
}
