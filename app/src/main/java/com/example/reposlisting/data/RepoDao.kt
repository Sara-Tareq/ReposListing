package com.example.reposlisting.data

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface RepoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(repos:List<Repo>)

    @Query("SELECT * FROM repositories where id = :repoId")
     fun loadRepo(repoId: Int): LiveData<Repo>

    @Query("SELECT * FROM repositories")
     fun loadAllRepos(): LiveData<List<Repo>>

    @Update
    suspend fun updateRepo(repo: Repo)
}