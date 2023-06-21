package com.example.cexup.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [MataKuliah::class, Mahasiswa::class, Dosen::class], version = 1, exportSchema = false)
abstract class DataDatabase :RoomDatabase() {
    abstract fun dataDao() : DataDao


    companion object {
        @Volatile
        private var INSTANCE: DataDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): DataDatabase {
            if (INSTANCE == null) {
                synchronized(DataDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DataDatabase::class.java, "database_kampus")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as DataDatabase
        }

    }
}