package com.example.tmcandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyListViewAdapter(
    context: Context,
    user: Array<User>) : BaseAdapter() {
    private val _context = context
    private val _user = user

    override fun getCount(): Int {
        return _user.size
    }

    override fun getItem(p0: Int): Any {
       return _user[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var convertView: View? = p1
        if (convertView == null) {
            convertView = LayoutInflater.from(_context)
                .inflate(R.layout.item_listview_fragment_second, p2, false)
        }
        val item = getItem(p0) as User
        val textViewItemUserName = convertView?.findViewById(R.id.itemUserName) as TextView
        val textViewItemUserAge = convertView?.findViewById(R.id.itemUserAge) as TextView
        val textViewItemUserWeight = convertView?.findViewById(R.id.itemUserWeight) as TextView

        textViewItemUserName.text = item.name
        textViewItemUserAge.text = item.age.toString()
        textViewItemUserWeight.text = item.weight.toString()
        return convertView
    }
}