package com.example.a485project.data

import android.app.Activity
import android.content.Context
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.a485project.R
import com.example.a485project.database.items.ItemDatabase
import com.example.a485project.database.items.Items

import com.example.a485project.model.Buy
import kotlinx.coroutines.launch


class Datasource: AppCompatActivity() {}


/**
    val db by lazy { ItemDatabase.getDatabase(this).itemDao()}



    var testlist = mutableListOf<Buy>(
        Buy(R.string.dish1, R.string.dish1_price, R.drawable.chickparm, R.string.Desc1, 3, R.string.Loc1 ),
        Buy(R.string.dish2, R.string.dish2_price, R.drawable.beefravi,R.string.Desc2, 5, R.string.Loc2),
        Buy(R.string.dish3, R.string.dish3_price, R.drawable.beefstrog,R.string.Desc3, 7, R.string.Loc3),
        Buy(R.string.dish4, R.string.dish4_price, R.drawable.bakesalm,R.string.Desc4, 21, R.string.Loc4),
        Buy(R.string.dish5, R.string.dish5_price, R.drawable.chicktikk,R.string.Desc5, 420, R.string.Loc5)
    )

    private val newItem =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                // Get the new note from the AddNoteActivity
                val name = testlist[0].stringResourceId1
                val price = testlist[0].stringResourceId2
                val pic = testlist[0].imageResourceId
                val desc = testlist[0].stringResourceId3
                val amount = testlist[0].NumResourceId2
                val Loc = testlist[0].stringResourceId4

                val x = Items(name, price, pic, desc, amount,Loc)


                lifecycleScope.launch() {
                    db.insertItem(x)
                }
            }
        }

    fun observeNotes(): List<Items>{

           return db.getAll()


    }
    fun loadDish(): List<Buy>{
        return testlist
    }
}
**/



