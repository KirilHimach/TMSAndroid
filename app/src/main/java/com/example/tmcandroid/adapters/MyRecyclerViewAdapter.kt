package com.example.tmcandroid.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmcandroid.R
import com.example.tmcandroid.data.FakeUser
import com.squareup.picasso.Picasso

class MyRecyclerViewAdapter(val fakeUser: List<FakeUser>) :
    RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val recyclerUserNameTextView: TextView
        val recyclerUserAgeTextView: TextView
        val recyclerUserCityTextView: TextView
        val recyclerUserAvatarImageView: ImageView

        init {
            recyclerUserNameTextView = view.findViewById(R.id.recyclerUserName)
            recyclerUserAgeTextView = view.findViewById(R.id.recyclerUserCity)
            recyclerUserCityTextView = view.findViewById(R.id.recyclerUserAge)
            recyclerUserAvatarImageView = view.findViewById(R.id.recyclerImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_item_fragment_recycler, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = fakeUser.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        println(fakeUser.get(position).name)
        holder.recyclerUserNameTextView.text = fakeUser.get(position).name
        holder.recyclerUserAgeTextView.text = fakeUser[position].age
        holder.recyclerUserCityTextView.text = fakeUser[position].city
        Picasso.get()
            .load(fakeUser[position].avatar)
            .into(holder.recyclerUserAvatarImageView)
    }
}