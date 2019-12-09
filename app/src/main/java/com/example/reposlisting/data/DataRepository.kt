package com.example.reposlisting.data

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.reposlisting.network.RepoWebService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DataRepository private constructor(context: Context){

    private val repoService: RepoWebService = RepoWebService.create()
    private val repoDataList: MutableLiveData<List<Repo>> = MutableLiveData()
    private val database: RepoDatabase? = RepoDatabase.getInstance(context)

    companion object: SingletonHolder<DataRepository,Context> (::DataRepository)

    fun getReposList(): MutableLiveData<List<Repo>> {

        repoService.getReposList().enqueue(object : Callback<List<Repo>> {
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