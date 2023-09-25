package com.example.selflearning

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast


class ListViewClass : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lits_view)

        supportActionBar?.hide()

        //1- ListView Declaration
        var listViewData: ListView = findViewById(R.id.list_view_data)
        var listViewNewData: ListView = findViewById(R.id.list_view_data)

        //2- Data Source Array
        var listData : List<String> = listOf("List 1","List 2","List 3","List 4","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5","List 5")

        //3- Array adapter
        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listData)

        //4- Set Adapter in List
        listViewData.adapter = adapter

        //5- Listening ListView
        listViewData.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = listData[position]

            Toast.makeText(this,selectedItem,Toast.LENGTH_SHORT).show()
            // Handle the item click event
        }


        var buttonBack: Button = findViewById(R.id.buttonBack)

        buttonBack.setOnClickListener{
            val intent = Intent(this, DiceRollerActivity::class.java)
            startActivity(intent)
        }



    }

    override fun onBackPressed() {
        // Handle back navigation here

        // Call super.onBackPressed() to allow the default back navigation behavior
        super.onBackPressed()
    }
}