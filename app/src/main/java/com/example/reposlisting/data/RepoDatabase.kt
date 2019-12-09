package com.example.reposlisting.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Repo::class],version = 1)
abstract class RepoDatabase: RoomDatabase() {

     abstract fun repoDao(): RepoDao

    companion object {
        private var INSTANCE: RepoDatabase? = null

        fun getInstance(context: Context): RepoDatabase? {
            if (INSTANCE == null) {
                synchronized(RepoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context,
                        RepoDatabase::class.java, "repos.db")
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}