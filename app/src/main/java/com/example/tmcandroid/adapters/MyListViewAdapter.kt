package com.example.tmcandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.tmcandroid.R
import com.example.tmcandroid.data.User

class MyListViewAdapter(
    context: Context,
    user: Array<User>) : BaseAdapter() {
    private val _context = context
    private val _user = user

    override fun getCount(): Int {
        return _user.size
    }

    override fun getItem(itemNumber: Int): Any {
       return _user[itemNumber]
    }

    override fun getItemId(id: Int): Long {
        return id.toLong()
    }

    override fun getView(itemNumber: Int, view: View?, viewGroup: ViewGroup?): View {
        var convertView: View? = view
        if (convertView == null) {
            convertView = LayoutInflater.from(_context)
                .inflate(R.layout.list_item_fragment_listview, viewGroup, false)
        }
        val item = getItem(itemNumber) as User
        val textViewItemUserName = convertView?.findViewById(R.id.recyclerUserName) as TextView
        val textViewItemUserAge = convertView.findViewById(R.id.recyclerUserCity) as TextView
        val textViewItemUserWeight = convertView.findViewById(R.id.recyclerUserAge) as TextView

        textViewItemUserName.text = item.name
        textViewItemUserAge.text = item.age.toString()
        textViewItemUserWeight.text = item.salary.toString()
        return convertView
    }
}