package com.example.a485project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.a485project.database.items.ItemDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivitySell : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sell)




        val add_item: Button = findViewById(R.id.button)
        add_item.setOnClickListener(View.OnClickListener(){
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


    }

    fun switchActivities(){
        val intent = Intent(this, AddItems::class.java)
        startActivity(intent)

    }

}