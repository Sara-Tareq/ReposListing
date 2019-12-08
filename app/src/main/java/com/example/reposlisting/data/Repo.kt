package com.example.reposlisting.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class Repo {
    @field:Json(name = "id")
    var id: Int = 0
    @field:Json(name = "name")
    var name: String? = null
    @field:Json(name = "stargazers_count")
    var starsCount: Int = 0
    @field:Json(name = "description")
    var description: String? = null
    var isBookmarked: Boolean = false

    fun getStarsCountString() : String{
        return starsCount.toString()
    }
}