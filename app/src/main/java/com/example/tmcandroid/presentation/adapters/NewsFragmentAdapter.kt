package com.example.tmcandroid.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmcandroid.R
import com.example.tmcandroid.domain.models.PostNews
import com.squareup.picasso.Picasso

class NewsFragmentAdapter(
    private val items: List<PostNews>,
    private val onItemClickListener: (View) -> Unit
) :
    RecyclerView.Adapter<NewsFragmentAdapter.RecyclerFragmentHolder>() {

    class RecyclerFragmentHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView
        val ageTextView: TextView
        val cityTextView: TextView
        val avatarImageView: ImageView

        init {
            nameTextView = view.findViewById(R.id.newsName)
            ageTextView = view.findViewById(R.id.newsLocation)
            cityTextView = view.findViewById(R.id.newsBirthday)
            avatarImageView = view.findViewById(R.id.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerFragmentHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fragment_news, parent, false)

        view.setOnClickListener {
            onItemClickListener(it)
        }
        return RecyclerFragmentHolder(view)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RecyclerFragmentHolder, position: Int) {
        holder.apply {
            nameTextView.text = items[position].author
            ageTextView.text = "" //TODO
            cityTextView.text = items[position].title
            Picasso.get()
                .load(items[position].urlToImage)
                .into(avatarImageView)
        }
    }
}