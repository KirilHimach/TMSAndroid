package com.example.tmcandroid

abstract class Animal(
    private val name: String,
    private val colour: String,
    private val age: Int,
    private val gender: Boolean  //gender: true - male, false - female
) {

    abstract fun run()

    abstract fun sleep()

    abstract fun eat(count: Boolean)

    override fun toString(): String {
        return "name = $name,\ncolour = $colour,\n" +
                "age = $age,\ngender = ${if (gender) "male" else "female"} \n"
    }
}

open class Cat(
    name: String,
    colour: String,
    age: Int,
    gender: Boolean
) : Animal(name, colour, age, gender) {
    private val nameCat = name

    override fun run() = println("$nameCat is running.")

    override fun sleep() = println("$nameCat is sleeping.")

    override fun eat(meal: Boolean) {
        if (meal) println("$nameCat is eating.") else println("$nameCat isn`t hungry.")
    }

    fun lookAtTheWindow() = println("$nameCat looking at the window.")

    open fun catch(aim: String) = println("$nameCat catching a $aim.")

    override fun toString(): String {
        return super.toString()
    }
}

class Tiger(
    name: String,
    colour: String,
    age: Int,
    gender: Boolean,
    private val weigh: Int
) : Cat(name, colour, age, gender) {

    override fun run() {
        super.run()
    }

    override fun sleep() {
        super.sleep()
    }

    override fun eat(meal: Boolean) {
        super.eat(meal)
    }

    override fun catch(aim: String) {
        super.catch(aim)
    }

    override fun toString(): String {
        return super.toString() + "weigh=$weigh"
    }
}


fun main() {
    val cat = Cat(name = "Bob", gender = true, colour = "Black", age = 15)
    val tiger = Tiger(colour = "Braun", weigh = 97, name = "Pushok", gender = true, age = 9)

    cat.catch("mouse")
    cat.eat(true)
    cat.run()
    cat.lookAtTheWindow()
    cat.sleep()
    println(cat)
    println()

    tiger.eat(false)
    tiger.catch("zebra")
    tiger.run()
    tiger.sleep()
    println(tiger)
}


