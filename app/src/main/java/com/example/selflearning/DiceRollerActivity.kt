package com.example.selflearning

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.selflearning.databinding.ActivityDiceRollerBinding

class DiceRollerActivity : AppCompatActivity() {
    private var diceValue1: Int = 1
    private var diceValue2: Int = 1
    private var rollCountData: String = ""
    private var rollMatchStatus: String = ""
    private var highestPointsText: String = ""
    private var rollCountTimes: Int = 1
    private var rollCountMatches: Int = 0
    private var higestPoint: Int = 0
    private var rollPoints: Int = 0
    lateinit var binding: ActivityDiceRollerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDiceRollerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        rollDice()
    }

    private fun rollDice(){
//        var rollDice1:ImageView = findViewById(R.id.rollDiceImage1)
//        var rollDice2:ImageView = findViewById(R.id.rollDiceImage2)
//        var matchStatusText:TextView = findViewById(R.id.matchStatus)
//        var rollCountText:TextView = findViewById(R.id.rollCount)
//        var highestPointText:TextView = findViewById(R.id.highestPintText)
//        var rollButton:Button = findViewById(R.id.rollButton)

        binding.rollButton.setOnClickListener{

            rollCountTimes++
            rollCountData = "Dice Rolled: $rollCountTimes Times"

            binding.rollCount.text = rollCountData

            if(rollCountTimes == 20){

                if(higestPoint == 0){
                    higestPoint = rollPoints
                }else if(rollPoints > higestPoint){
                    higestPoint = rollPoints
                }

                binding.highestPintText.text = "Highest point: $higestPoint"

                val builder = AlertDialog.Builder(this)
                //set title for alert dialog
                builder.setTitle("Game Over")
                //set message for alert dialog
                builder.setMessage("In ${rollCountTimes} rolls you have earned ${rollPoints} points")
                builder.setIcon(android.R.drawable.ic_dialog_alert)

                //performing positive action
                builder.setPositiveButton("Try Again"){dialogInterface, which ->
                    binding.rollCount.text = ""
                    binding.matchStatus.text= ""
                    rollCountTimes = 0
                    rollCountMatches = 0
                    rollPoints = 0
                    dialogInterface.dismiss()
                }
                // Create the AlertDialog
                val alertDialog: AlertDialog = builder.create()
                // Set other dialog properties
                alertDialog.setCancelable(false)
                alertDialog.show()
            }

            diceValue1 = (1..6).random()
            diceValue2 = (1..6).random()

            if (diceValue1 == diceValue2){
                rollCountMatches++
                rollPoints += 5
                rollMatchStatus = "Dice Matched"

                binding.matchStatus.setTextColor(Color.GREEN)
            }else{
                rollPoints = rollPoints - 1
                rollMatchStatus = "Dice Not Matched"
                binding.matchStatus.setTextColor(Color.RED)
            }

            binding.matchStatus.text = rollMatchStatus

            var data1 = randomNumber(diceValue1)
            var data2 = randomNumber(diceValue2)

            binding.rollDiceImage1.setImageResource(data1)
            binding.rollDiceImage2.setImageResource(data2)
        }
    }

    private fun randomNumber(randomData: Int): Int {
       return when(randomData){
            1 -> R.drawable.one
            2 -> R.drawable.two
            3 -> R.drawable.three
            4 -> R.drawable.four
            5 -> R.drawable.five
            6 -> R.drawable.six
            else -> R.drawable.one
        }
    }
}