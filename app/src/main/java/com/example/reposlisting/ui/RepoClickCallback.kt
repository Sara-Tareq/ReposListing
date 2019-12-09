package com.example.reposlisting.ui

import com.example.reposlisting.data.Repo

interface RepoClickCallback {

     fun onClick(repo: Repo)
}