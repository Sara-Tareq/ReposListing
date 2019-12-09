package com.example.reposlisting.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.reposlisting.data.Repo

class RepoViewModel : ViewModel() {

    val  repo: MutableLiveData<Repo> = MutableLiveData()
}