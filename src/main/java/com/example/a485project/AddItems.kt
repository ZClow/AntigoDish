package com.example.a485project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.example.a485project.MainActivity2
import com.example.a485project.R
import com.example.a485project.MainActivity
import com.example.a485project.data.Datasource
import com.example.a485project.model.Buy

class AddItems : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_items)

        val mainsell: Button = findViewById(R.id.button6)
        mainsell.setOnClickListener(View.OnClickListener(){
            switchActivities()

        })

        val buy: Button = findViewById(R.id.button3)
        buy.setOnClickListener(View.OnClickListener(){
            val intent2 = Intent(this, MainActivity2::class.java)
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
        submit.setOnClickListener(View.OnClickListener {
            x1 = dishName.text.toString()
            x4 = dishDescription.text.toString()
            x2 = itemCost.text.toString()
            x5 = quantityAvailable.text.toString().toInt()
            x6 = shippingLocation.text.toString()
            Datasource().testlist.add(Buy(x1,x2,R.drawable.beefstrog,x4,x5,x6))
        })



    }

    fun switchActivities(){

        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }



}