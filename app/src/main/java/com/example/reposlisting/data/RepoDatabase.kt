package com.example.reposlisting.data

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

abstract class RepoDatabase: RoomDatabase() {

    companion object {
        private var INSTANCE: RepoDatabase? = null

        fun getInstance(context: Context): RepoDatabase? {
            if (INSTANCE == null) {
                synchronized(RepoDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        RepoDatabase::class.java, "weather.db")
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