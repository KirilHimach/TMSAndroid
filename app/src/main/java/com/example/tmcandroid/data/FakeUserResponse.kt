package com.example.tmcandroid.data

class FakeUserResponse(val results: List<FakeUser>)

    data class FakeUser(val name: Name,
                        val location: Location,
                        val email: String,
                        val dob: Dob,
                        val phone: String,
                        val picture: Picture) : java.io.Serializable
    data class Name(val first: String, val last: String)
    data class Dob(val date: String, val age: String)
    data class Picture(val large: String)
    data class Location(val city: String, val state: String, val country: String)
