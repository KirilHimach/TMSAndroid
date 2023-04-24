package com.example.tmcandroid.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tmcandroid.R
import com.example.tmcandroid.data.*
import com.squareup.picasso.Picasso
import retrofit2.Response


class NewsFragmentAdapter :
    RecyclerView.Adapter<NewsFragmentAdapter.RecyclerFragmentHolder>() {

    private var fakeUsers = emptyList<FakeUser>()
    private var onClickListener: OnClickListener? = null

    /**
     * This method sets the fakeUsers from the FakeUserFactory
     */
    @SuppressLint("NotifyDataSetChanged")
    fun setFakeUsers(list: Response<FakeUserResponse>) {
        fakeUsers = list.body()?.results ?: getSafeList()
        notifyDataSetChanged()
    }

    /**
     * This method will substitute a safe sheet
     * if there is no data transfer.
     */
    private fun getSafeList() : List<FakeUser> {
        return listOf(FakeUser(
            Name(first = "Unknown", last = "Unknown"),
            Location(city = "Unknown", state = "Unknown", country = "Unknown"),
            email = "Unknown",
            Dob(date = "Unknown", age = "Unknown"),
            phone = "Unknown",
            Picture(large = "Unknown")
        ))
    }

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
        return RecyclerFragmentHolder(view)
    }

    override fun getItemCount() = fakeUsers.size

    override fun onBindViewHolder(holder: RecyclerFragmentHolder, position: Int) {
        val name = fakeUsers[position].name.first +
                " " + fakeUsers[position].name.last
        holder.nameTextView.text = name
        holder.ageTextView.text = fakeUsers[position].dob.age
        holder.cityTextView.text = fakeUsers[position].location.city
        Picasso.get()
            .load(fakeUsers[position].picture.large)
            .into(holder.avatarImageView)

        //Observer
        holder.itemView.setOnClickListener {
            onClickListener?.onClick(fakeUsers[position])
        }
    }

    /**
     * This is the Observer, he reacts to clicking on item.
     */
    interface OnClickListener {
        fun onClick(model: FakeUser)
    }

    fun setOnClickListener(onClickListener: OnClickListener) {
        this.onClickListener = onClickListener
    }

}