package com.example.a485project

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.a485project.database.items.ItemDatabase
import com.example.a485project.database.items.Items
import com.example.a485project.model.Buy
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class AddItems : AppCompatActivity() {



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
                /**

                lifecycleScope.launch() {
                    db.insertItem(x)
                }
                **/
            }
        }
    /**
    private fun observeNotes() {
        lifecycleScope.launch {
            db.getAll()  }
                }
    **/


    




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)
        //observeNotes()






        val mainsell: Button = findViewById(R.id.button6)
        mainsell.setOnClickListener(View.OnClickListener(){
            switchActivities()

        })

        val buy: Button = findViewById(R.id.button3)
        buy.setOnClickListener(View.OnClickListener(){
            val intent2 = Intent(this, MainActivity2::class.java)
            finish()
            startActivity(intent2)

        })

        val cart: Button = findViewById(R.id.button5)
        cart.setOnClickListener(View.OnClickListener(){
            val intent2 = Intent(this, cart2::class.java)
            startActivity(intent2)

        })



        var x1: String
        var x2: String
        /**var x3: String**/
        var x4: String
        var x5: Int
        var x6: String


        val dishName: EditText = findViewById(R.id.dish_name)


        val dishDescription: EditText = findViewById(R.id.dish_description)


        /**val uploadImage: Button = findViewById(R.id.upload_photo)
        uploadImage.setOnClickListener(View.OnClickListener {
        x3 =
        })**/

        val itemCost: EditText = findViewById(R.id.item_cost)


        val quantityAvailable: EditText = findViewById(R.id.quant_avail)


        val shippingLocation: EditText = findViewById(R.id.ship_location)

        val submit: Button = findViewById(R.id.submit_item)
        /**
        submit.setOnClickListener(View.OnClickListener {
            x1 = dishName.text.toString()
            x4 = dishDescription.text.toString()
            x2 = itemCost.text.toString()
            x5 = quantityAvailable.text.toString().toInt()
            x6 = shippingLocation.text.toString()
            testlist.add(Buy(x1,x2,R.drawable.beefstrog,x4,x5,x6))
        })
        **/


    }

    fun switchActivities(){

        val intent = Intent(this, MainActivitySell::class.java)
        finish()
        startActivity(intent)
    }

    fun loadDish(): List<Buy>{
        return testlist
    }




}