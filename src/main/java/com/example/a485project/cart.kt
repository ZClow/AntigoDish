package com.example.a485project

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.a485project.MainActivity2
import com.example.a485project.R
import com.example.a485project.AddItems


class cart : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cart)

        val total: Button = findViewById(R.id.total)
        val money: TextView = findViewById(R.id.total2)
        total.setOnClickListener(View.OnClickListener(){
            money.text = "$22.18"

        })

        val buy: Button = findViewById(R.id.button3)
        buy.setOnClickListener(View.OnClickListener(){
            val intent2 = Intent(this, MainActivity2::class.java)
            startActivity(intent2)

        })


    }

    fun switchActivities(){
        val intent = Intent(this, AddItems::class.java)
        startActivity(intent)

    }

}