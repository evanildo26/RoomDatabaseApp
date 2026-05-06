package com.example.roomdatabaseapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseapp.databinding.UserItemBinding

class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    private var userList = emptyList<User>()

    // This part holds onto our "item" view (the card)
    class MyViewHolder(val binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int = userList.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.binding.textViewId.text = currentItem.id.toString()
        holder.binding.textViewName.text = currentItem.name
        holder.binding.textViewAge.text = "Age: ${currentItem.age}"
    }

    // This updates the list when something changes
    fun setData(users: List<User>) {
        this.userList = users
        notifyDataSetChanged()
    }
}
