package com.example.cexup

import android.app.Application
import com.example.cexup.database.DataDatabase
import com.example.cexup.helper.DataRepos

class MyApplication  : Application() {
    val database by lazy { DataDatabase.getDatabase(this) }
    val repository by lazy { DataRepos(this)}
}