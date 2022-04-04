package com.example.a485project.database.items

import android.content.ClipData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao

interface ItemsDao{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertItem(item: Items)

    @Query("SELECT * FROM item")
    fun getAll(): Flow<List<Items>>
}