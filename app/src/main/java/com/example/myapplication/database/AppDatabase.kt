package com.example.myapplication.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.myapplication.models.Post
import com.example.myapplication.models.PostDao

@Database(entities = arrayOf(Post::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun postDao(): PostDao
}