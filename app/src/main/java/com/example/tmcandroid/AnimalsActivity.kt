package com.example.tmcandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class Animals : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animals)
    }

    fun createCat(view: View) {
        val cat = Cat(name = "Tom", colour = "pink", age = 18, gender = true)
        cat.catch("cheese")
        cat.eat(true)
        val showText = findViewById<TextView>(R.id.cat_info)
        showText.text = cat.toString()
    }

    fun createTiger(view: View) {
        val tiger = Tiger(name = "Barsik", colour = "gray", age = 33, gender = false, weigh = 125)
        tiger.eat(false)
        tiger.catch("mouse")
        val showText = findViewById<TextView>(R.id.tiger_info)
        showText.text = tiger.toString()
    }
}