package com.example.reposlisting.network

import com.example.reposlisting.data.Repo
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface RepoWebService {
    @GET("orgs/square/repos")
    fun getReposList(): Call<List<Repo>>


    companion object Factory {
        fun create(): RepoWebService {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder().add(
                            KotlinJsonAdapterFactory()
                        ).build()))
                .build()

            return retrofit.create<RepoWebService>(RepoWebService::class.java)
        }
    }
}