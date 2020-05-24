package com.ajay.tech.news.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.ajay.tech.news.data.db.entity.DummyEntity


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Dao
interface DummyDao {

    @Query("SELECT * FROM dummy_entity")
    fun getAll(): List<DummyEntity>

    @Insert
    fun insert(entity: DummyEntity)

    @Delete
    fun delete(entity: DummyEntity)
}