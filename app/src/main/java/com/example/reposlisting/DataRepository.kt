package com.example.reposlisting

import androidx.lifecycle.MutableLiveData
import com.example.reposlisting.data.Repo
import com.example.reposlisting.network.RepoWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object DataRepository {
    private val repoService: RepoWebService = RepoWebService.create()
    val repoDataList: MutableLiveData<List<Repo>> = MutableLiveData()

    fun getReposList(): MutableLiveData<List<Repo>>{

        repoService.getReposList().enqueue(object : Callback<List<Repo>>{
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<Repo>>,
                response: Response<List<Repo>>
            ) {
                repoDataList.value = response.body()
            }

        })
        return repoDataList

    }
}