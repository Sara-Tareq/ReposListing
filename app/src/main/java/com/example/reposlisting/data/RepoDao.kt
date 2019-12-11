package com.example.reposlisting.data

import androidx.lifecycle.LiveData
import androidx.room.*
import java.util.*

@Dao
interface RepoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(repo: Repo)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(repos: List<Repo>)

    @Query("SELECT * FROM repositories where id = :repoId")
    fun loadRepo(repoId: Int): LiveData<Repo>

    @Query("SELECT * FROM repositories")
    fun loadAllRepos(): LiveData<List<Repo>>

    @Query("SELECT * FROM repositories where isBookmarked = 1")
    fun loadBookmarkedRepos(): List<Repo>

    @Update
    suspend fun updateRepo(repo: Repo)

    @Transaction
    suspend fun insertOrUpdate(repoList: List<Repo>) {

        val userBookmarkedRepos: List<Repo> = loadBookmarkedRepos()
        if (userBookmarkedRepos.isEmpty()) {
            insertAll(repoList)
        } else {
            for (bookmarked in userBookmarkedRepos) {
                val index: Int = repoList.indexOf(Repo(bookmarked.id))
                if (index != -1)
                    repoList[index].isBookmarked = true
            }
            insertAll(repoList)
        }
    }
}