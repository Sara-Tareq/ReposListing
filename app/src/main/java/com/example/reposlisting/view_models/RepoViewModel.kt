package com.example.reposlisting.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reposlisting.data.DataRepository
import com.example.reposlisting.data.Repo

class RepoViewModel(app: Application) : AndroidViewModel(app) {

    val  repo: MutableLiveData<Repo> = MutableLiveData()
    private val dataRepository: DataRepository = DataRepository.getInstance(app.applicationContext)

    fun updateRepoDetails(newRepoDetails: Repo){
        dataRepository.updateRepo(newRepoDetails)
    }
}