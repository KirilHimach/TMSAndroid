package com.example.tmcandroid.presentation.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.tmcandroid.R
import com.example.tmcandroid.domain.models.PostNews
import com.example.tmcandroid.presentation.activities.BasicActivity
import com.example.tmcandroid.presentation.activities.HiltApp
import com.example.tmcandroid.presentation.fragments.NewsFragment
import com.squareup.picasso.Picasso
import kotlinx.coroutines.withContext

class NewsFragmentAdapter(
    private var context: Context,
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
            Glide
                .with(context)
                .load(items[position].urlToImage)
                .into(avatarImageView)
        }
    }
}