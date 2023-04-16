package com.example.tmcandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmcandroid.R
import com.example.tmcandroid.fragments.User

class MyRecyclerViewAdapter(val user: Array<User>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerUserNameTextView: TextView
        val recyclerUserAgeTextView: TextView
        val recyclerUserWeightTextView: TextView

        init {
            recyclerUserNameTextView = view.findViewById(R.id.recyclerUserName)
            recyclerUserAgeTextView = view.findViewById(R.id.recyclerUserAge)
            recyclerUserWeightTextView = view.findViewById(R.id.recyclerUserWeight)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_fragment_third, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = user.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.recyclerUserNameTextView.text = user[position].name
        holder.recyclerUserAgeTextView.text = user[position].age.toString()
        holder.recyclerUserWeightTextView.text = user[position].salary.toString()
    }
}