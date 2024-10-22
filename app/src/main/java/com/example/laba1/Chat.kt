package com.example.laba1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

data class Chat(
    val senderName: String,
    val lastMessage: String,
    val time: String,
    val profileImage: Int
)

class ChatsAdapter(private val chats: List<Chat>) : RecyclerView.Adapter<ChatsAdapter.ChatViewHolder>() {

    class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = view.findViewById(R.id.textName)
        val textLastMessage: TextView = view.findViewById(R.id.textLastMessage)
        val textTime: TextView = view.findViewById(R.id.textTime)
        val imageProfile: ImageView = view.findViewById(R.id.imageProfile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.chat_item, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chats[position]
        holder.textName.text = chat.senderName
        holder.textLastMessage.text = chat.lastMessage
        holder.textTime.text = chat.time
        holder.imageProfile.setImageResource(chat.profileImage)
    }

    override fun getItemCount(): Int {
        return chats.size
    }
}
