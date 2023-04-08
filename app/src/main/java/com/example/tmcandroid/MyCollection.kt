package com.example.tmcandroid

import android.util.Log

class MyCollection {
    private val cars = listOf("BMW", "Volvo", "MAZ", null)
    private val cars2 = mutableListOf("Belaz", "KIA", "Toyota", 1, 5, 'S', null)
    private val cars3 = listOfNotNull(cars + cars2 + 7 + 61 + "Tesla" - 5 - 444)

    private val fruits = setOf("Banana", "Apple", "Orange", null)
    private val fruits2 = mutableSetOf(1, null, "Chery", "Apple", "Lemon", "Dorian", 9, 92)
    private val fruits3 = hashSetOf(
        "Banana", "Apple", "Orange", null, 1, null,
        "Chery", "Apple", "Lemon", "Dorian", 9, 92, 4, 85 + 96,
        0, -15, -48, 45, 88, 1, 92)

    private val gadgets =
        mapOf(1 to "Apple", 2 to "Huawei",
        3 to "Lenovo", Pair(4, "Atlant"), Pair(5, "Horizont"))
    private val gadgets2 =
        mutableMapOf(23 to "Acer", 't' to 24324, '?' to "NEC", "one" to "Logitech")
    private val gadgets3: MutableMap<Int, String> = mutableMapOf()


    fun getGadgets(): String {
        Log.d("TEST_ANDROID", "Map collection -------------------------")

        for ((key, value) in gadgets) Log.d("TEST_ANDROID", "$key - $value")
        println("------------------------------------")

        gadgets2.forEach { (any, any2) -> Log.d("TEST_ANDROID", "$any - $any2") }
        println("------------------------------------")

        gadgets3 += 11 to "HP"
        gadgets3.put(15, "Cisco")
        gadgets3.forEach { (any, any2) -> Log.d("TEST_ANDROID", "$any - $any2") }
        return gadgets.toString() + gadgets2.toString() + gadgets3.toString()
    }

    fun getFruits() : String {
        Log.d("TEST_ANDROID", "Set collection -------------------------")

        fruits.forEach { Log.d("TEST_ANDROID", it.toString()) }
        println("------------------------------------")

        fruits2.forEach { Log.d("TEST_ANDROID", it.toString()) }
        println("------------------------------------")

        Log.d("TEST_ANDROID", "$fruits3")
        return fruits.toString() + fruits2.toString() + fruits3.toString()
    }

    fun getCars() : String {
        Log.d("TEST_ANDROID", "List collection -------------------------")

        cars.forEach {
            Log.d("TEST_ANDROID", "$it - ${it?.lowercase() ?: "not null"}")
        }
        println("------------------------------------")

        for (myCar in cars2) Log.d("TEST_ANDROID", myCar.toString())
        println("------------------------------------")

        cars3.stream().sorted().forEach {
            Log.d("TEST_ANDROID", it.toString())
        }
        return cars.toString() + cars2.toString() + cars3.toString()
    }
}