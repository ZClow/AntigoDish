package com.example.a485project

import android.app.Application
import com.example.a485project.database.items.ItemDatabase
import com.example.a485project.database.items.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class ItemApplication : Application() {

    val database by lazy { ItemDatabase.getDatabase(this, CoroutineScope(SupervisorJob()))}
    val repository by lazy { ItemRepository(database.itemDao()) }
}