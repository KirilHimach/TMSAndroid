package com.example.tmcandroid.data.repositories.remote

import com.example.tmcandroid.data.remote.dto.PostDto

//Step 3. We are get the response from the server hire.
class PostsRemoteImpl : PostsRemote {
    override fun getPosts(): List<PostDto> =
        mutableListOf(
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            ),
            PostDto(
                name = "Bob White",
                location =  "Minsk",
                email = "bobwhite@mail.ru",
                dob = "05.11.1990",
                phone = "+375297235613",
                picture = "https://randomuser.me/api/portraits/men/75.jpg"
            )
        )

    override fun getPostInfo(): PostDto =
        PostDto(
            name = "Bob White",
            location =  "Minsk",
            email = "bobwhite@mail.ru",
            dob = "05.11.1990",
            phone = "+375297235613",
            picture = "https://randomuser.me/api/portraits/men/75.jpg"
        )
}


//PostDto(
//name = Name(first = "Bob", last = "White"),
//Location(city = "Minsk", state = "Minsk aria", country = "Belarus"),
//email = "bobwhite@mail.ru",
//Dob(date = "05.11.1990", age = "33"),
//phone = "+375297235613",
//Picture(large = "https://randomuser.me/api/portraits/men/75.jpg")
//),

