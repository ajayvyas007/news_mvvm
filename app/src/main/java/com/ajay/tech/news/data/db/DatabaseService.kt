package com.ajay.tech.news.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ajay.tech.news.data.db.dao.DummyDao
import com.ajay.tech.news.data.db.entity.DummyEntity
import javax.inject.Singleton


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Singleton
@Database(
    entities = [
        DummyEntity::class
    ],
    exportSchema = false,
    version = 1
)
abstract class DatabaseService : RoomDatabase() {

    abstract fun dummyDao(): DummyDao
}