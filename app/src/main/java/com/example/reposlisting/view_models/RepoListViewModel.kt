package com.example.reposlisting.view_models

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reposlisting.data.DataRepository
import com.example.reposlisting.data.Repo

class RepoListViewModel(app:Application): AndroidViewModel(app) {

      val repoDataList: MutableLiveData<List<Repo>> = DataRepository.getInstance(app.applicationContext).getReposList()
}