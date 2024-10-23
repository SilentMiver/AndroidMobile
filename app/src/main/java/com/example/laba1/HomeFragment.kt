package com.example.laba1

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment() {
    private lateinit var recyclerViewChats: RecyclerView
    private val TAG = "HomeFragment"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView called")
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewChats = view.findViewById(R.id.recyclerViewChats)

        val fakeChats = listOf(
            Chat("Иван Иванов", "Привет, как ты?", "12:45", R.drawable.ic_profile_placeholder)
        )

        val adapter = ChatsAdapter(fakeChats)
        recyclerViewChats.adapter = adapter
        recyclerViewChats.layoutManager = LinearLayoutManager(context)
    }
}