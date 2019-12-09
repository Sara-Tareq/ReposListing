package com.example.reposlisting.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos:List<Repo>)

    @Query("SELECT * FROM repositories where id = :repoId")
    suspend fun loadRepo(repoId: Int): Repo

    @Query("SELECT * FROM repositories")
    suspend fun loadAllRepos(): List<Repo>

    @Update
    suspend fun updateRepo(repo: Repo)
}