package com.example.tmcandroid.data

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class FakeUserFactory {



   fun getFakeUser() : List<FakeUser> {
        val users = List(10){i -> FakeUser("Name", "Minsk", "15",
               "https://randomuser.me/api/portraits/men/75.jpg")}
       return users
    }

    /**
     * This method returns an empty list,
     * but the retrofit does its job correctly.
     * You need to use the wait method. I didn't have enough time to deal with it.
     */

    private fun generateFakeUser() : List<FakeUser>{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://randomuser.me/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(FakeUserInterface::class.java)

        val users = mutableListOf<FakeUser>()

         val r = retrofit.getUser(10).enqueue(object : Callback<FakeUserResponse> {
            override fun onResponse(
                call: Call<FakeUserResponse>,
                response: Response<FakeUserResponse>
            ) {
                for (i in 0 until(response.body()?.results?.size ?: 0)) {
                    val box = response.body()?.results?.get(i)
                    val nameLastname = box?.name?.first + " " + box?.name?.last
                    val user = FakeUser(name = nameLastname,
                        age = box?.dob?.age ?: "15",
                        city = box?.location?.city ?: "Minsk",
                        avatar = box?.picture?.large.toString())
                    users.add(i, user)
                }
            }

            override fun onFailure(call: Call<FakeUserResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })

        println(users + 222222)
        return users
    }


    data class FakeUserResponse(val results: List<User>)
    data class User(val name: Name, val dob: Dob, val location: Location, val picture: Picture)
    data class Name(val first: String, val last: String)
    data class Dob(val age: String)
    data class Picture(val large: String)
    data class Location(val city: String)

    interface FakeUserInterface {
        @GET("/api")
        fun getUser(@Query("results") count: Int) : Call<FakeUserResponse>
    }
}
