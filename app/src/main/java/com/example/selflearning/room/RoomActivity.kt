package com.example.selflearning.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.room.Room
import com.example.selflearning.databinding.ActivityRoomBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RoomActivity : AppCompatActivity() {
    private lateinit var  database: ContactDatabase
    lateinit var binding : ActivityRoomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        database = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "contactDB").build()


        binding.addRoomData.setOnClickListener {
            GlobalScope.launch {
                database.contactDao().insertContact(Contact(0,"Irfan" , "99249545"))
            }
        }

        database.contactDao().getContact().observe(this) { contactList ->
            val contactNames = contactList.map { it.name }

            var selectedContact : Contact

            binding.listViewRoom.setOnItemClickListener { _, _, position, _ ->
                selectedContact = contactList[position] // Store the selected contact

                binding.deleteRoomData.setOnClickListener {
                    GlobalScope.launch {
                        database.contactDao().deleteContact(selectedContact)
                    }
                }
            }

            val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, contactNames)
            binding.listViewRoom.adapter = adapter
        }
    }
}