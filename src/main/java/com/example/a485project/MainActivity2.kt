package com.example.a485project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.a485project.adapter.ItemAdapter
import com.example.a485project.data.Datasource


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Initialize data.
        val myDataset = Datasource().loadDish()

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(this, myDataset)

        // Use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true)

        val add_item: Button = findViewById(R.id.button6)
        add_item.setOnClickListener(View.OnClickListener(){
            val intent = Intent(this, AddItems::class.java)
            startActivity(intent)

        })

        val buy: Button = findViewById(R.id.button3)
        buy.setOnClickListener(View.OnClickListener(){
            val intent2 = Intent(this, MainActivity::class.java)
            startActivity(intent2)

        })

        val cart: Button = findViewById(R.id.button5)
        cart.setOnClickListener(View.OnClickListener(){
            val intent2 = Intent(this, cart2::class.java)
            startActivity(intent2)

        })


    }
}