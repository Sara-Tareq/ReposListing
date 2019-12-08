package com.example.reposlisting.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reposlisting.DataRepository
import com.example.reposlisting.data.Repo

class RepoListViewModel: ViewModel() {

      val repoDataList: MutableLiveData<List<Repo>> = DataRepository.getReposList()
}