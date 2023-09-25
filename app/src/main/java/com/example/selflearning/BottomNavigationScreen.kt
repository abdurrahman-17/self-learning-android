package com.example.selflearning

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.selflearning.databinding.ActivityBottomNavigationScreenBinding



class BottomNavigationScreen : AppCompatActivity() {

    private lateinit var binding : ActivityBottomNavigationScreenBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityBottomNavigationScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeScreen())


        binding.bottomNavigationView.setOnItemSelectedListener {
           when(it.itemId){
               R.id.bottom_home -> replaceFragment(HomeScreen())
               R.id.bottom_profile -> replaceFragment(ProfileScreen())
               R.id.bottom_setting -> replaceFragment(Settings())
               else -> {}
           }
           true
       }

    }

    private  fun replaceFragment(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}