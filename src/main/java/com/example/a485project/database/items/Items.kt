package com.example.a485project.database.items

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "item")
data class Items(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @NonNull @ColumnInfo(name = "item_name") val itemName: Int,
    @NonNull @ColumnInfo(name = "Price") val price: Int,
    @NonNull @ColumnInfo(name = "Picture") val picture: Int,
    @NonNull @ColumnInfo(name = "description") val description: Int,
    @NonNull @ColumnInfo(name = "location") val location: Int
)