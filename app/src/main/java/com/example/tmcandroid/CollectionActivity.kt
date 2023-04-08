package com.example.tmcandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class CollectionActivity : AppCompatActivity() {
    private val collection = MyCollection()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)
    }

    fun createCar(view: View) {
        val showCar = findViewById<TextView>(R.id.car_info)
        showCar.text = collection.getCars()
    }

    fun createFruit(view: View) {
        val showFruit = findViewById<TextView>(R.id.fruit_info)
        showFruit.text = collection.getFruits()
    }

    fun createGadget(view: View) {
        val showGadget = findViewById<TextView>(R.id.gadget_info)
        showGadget.text = collection.getGadgets()
    }
}