package com.example.reposlisting.view_models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.reposlisting.data.DataRepository
import com.example.reposlisting.data.Repo

class RepoListViewModel(app:Application): AndroidViewModel(app) {

      val repoDataList: LiveData<List<Repo>>? = DataRepository.getInstance(app.applicationContext).getReposList()
}