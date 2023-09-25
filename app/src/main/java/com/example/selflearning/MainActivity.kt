package com.example.selflearning

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.selflearning.databinding.ActivityMainBinding
import com.example.selflearning.room.RoomActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
//    private var button : Button? =null
//    private var bottomNav : Button? =null
//    private var recyclerButton : Button? =null
//    private var postScreeButton : Button? =null
//    private var smallWidgetButton : Button? =null
//    private var gridViewButton : Button? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        button = findViewById(R.id.button)
//        bottomNav = findViewById(R.id.bottom_nav_screen)
//        recyclerButton = findViewById(R.id.button2)
//        postScreeButton = findViewById(R.id.postDataButton)
//        smallWidgetButton = findViewById(R.id.smallWidgetButton)
//        gridViewButton = findViewById(R.id.gridViewButton)

        binding.button.setOnClickListener {
            val intent = Intent(this, ListViewClass::class.java)
            startActivity(intent)
        }

        binding.bottomNavScreen.setOnClickListener {
            val intent = Intent(this, BottomNavigationScreen::class.java)
            startActivity(intent)
        }

        binding.button2.setOnClickListener {
            val intent = Intent(this, RecyclerViewScreen::class.java)
            startActivity(intent)
        }

        binding.postDataButton.setOnClickListener {
            val intent = Intent(this, PostDataScreen::class.java)
            startActivity(intent)
        }

        binding.smallWidgetButton.setOnClickListener {
            val intent = Intent(this, SmallWidgetActivity::class.java)
            startActivity(intent)
        }

        binding.gridViewButton.setOnClickListener {
            val intent = Intent(this, GridViewActivity::class.java)
            startActivity(intent)
        }

        binding.roomButton.setOnClickListener {
            val intent = Intent(this, RoomActivity::class.java)
            startActivity(intent)
        }
    }
}