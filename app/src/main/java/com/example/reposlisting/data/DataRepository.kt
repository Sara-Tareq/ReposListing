package com.example.reposlisting.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.reposlisting.network.RepoWebService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.CoroutineContext

class DataRepository private constructor(context: Context) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private val repoService: RepoWebService = RepoWebService.create()
    private val repoDataList: LiveData<List<Repo>>?
    private var repoDetails: MediatorLiveData<Repo>? = MediatorLiveData()
    private var repoDao: RepoDao?

    init {
        val database: RepoDatabase? = RepoDatabase.getInstance(context)
        repoDao = database?.repoDao()
        repoDataList = repoDao?.loadAllRepos()
    }

    companion object : SingletonHolder<DataRepository, Context>(::DataRepository)

    fun getReposList(): LiveData<List<Repo>>? {
        refreshData()
        return repoDataList
    }

    private fun refreshData() {
        repoService.getReposList().enqueue(object : Callback<List<Repo>> {
            override fun onFailure(call: Call<List<Repo>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(
                call: Call<List<Repo>>,
                response: Response<List<Repo>>
            ) {
                launch {

                    saveReposList(response.body())
                }
            }

        })
    }

    suspend fun saveReposList(reposList: List<Repo>?) {

        if (reposList != null)
            withContext(Dispatchers.IO) {
                repoDao?.insertAll(reposList)
            }

    }

    fun updateRepo(repo: Repo) {
        launch {
            repoDao?.updateRepo(repo)
        }
    }
}