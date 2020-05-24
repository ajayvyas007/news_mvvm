package com.ajay.tech.news.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


/**
 * Created by Ajay Vyas on 23/05/20.
 * Own Project
 * ajv_007@hotmail.com
 */
@Entity(tableName = "dummy_entity")
data class DummyEntity(

    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Long,

    @ColumnInfo(name = "name")
    @NotNull
    val name: String
)