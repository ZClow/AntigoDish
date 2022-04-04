package com.example.a485project.database.items

import android.content.Context
import android.provider.ContactsContract
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.a485project.R
import com.example.a485project.model.Buy
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = arrayOf(Items::class),
    version = 1,
    exportSchema = true
)
abstract class ItemDatabase : RoomDatabase() {

    abstract fun itemDao(): ItemsDao

    companion object {
        @Volatile
        private var INSTANCE: ItemDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): ItemDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemDatabase::class.java,
                    "word_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(WordDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }


    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var itemDao = database.itemDao()

                    // Delete all content here.
                    //wordDao.deleteAll()

                    var testlist = mutableListOf<Buy>(
                        Buy(R.string.dish1, R.string.dish1_price, R.drawable.chickparm, R.string.Desc1, 3, R.string.Loc1 ),
                        Buy(
                            R.string.dish2, R.string.dish2_price, R.drawable.beefravi,
                            R.string.Desc2, 5, R.string.Loc2),
                        Buy(
                            R.string.dish3, R.string.dish3_price, R.drawable.beefstrog,
                            R.string.Desc3, 7, R.string.Loc3),
                        Buy(
                            R.string.dish4, R.string.dish4_price, R.drawable.bakesalm,
                            R.string.Desc4, 21, R.string.Loc4),
                        Buy(
                            R.string.dish5, R.string.dish5_price, R.drawable.chicktikk,
                            R.string.Desc5, 420, R.string.Loc5)
                    )

                    val name = testlist[0].stringResourceId1
                    val price = testlist[0].stringResourceId2
                    val pic = testlist[0].imageResourceId
                    val desc = testlist[0].stringResourceId3
                    val amount = testlist[0].NumResourceId2
                    val Loc = testlist[0].stringResourceId4

                    val x = Items(name, price, pic, desc, amount,Loc)



                    itemDao.insertItem(x)


                }
            }
        }
    }




}