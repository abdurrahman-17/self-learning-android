package com.example.selflearning

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.widget.SwitchCompat
import com.google.android.material.chip.Chip
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_small_widget.*
import java.util.Calendar

class SmallWidgetActivity : AppCompatActivity() {

    var checkBox1 : CheckBox? = null
    var checkBox2 : CheckBox? = null
    var radioGroup : RadioGroup? = null
    var radioButton1 : RadioButton? = null
    var radioButton2 : RadioButton? = null
    var switchButton1 : SwitchCompat? = null
    var switchButton2 : SwitchCompat? = null
    var chip1 : Chip? = null
    var chip2 : Chip? = null
    var chip3 : Chip? = null
    var floatingActionButton : FloatingActionButton? = null
    var ratingBar : RatingBar? = null
    var seekBarSlide : SeekBar? = null
    var toggleButton1 : ToggleButton? = null
    var toggleButton2 : ToggleButton? = null
    var datePickerButton : Button? = null
    var timePickerButton : Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_small_widget)

        checkBox1 = findViewById(R.id.checkBox1)
        checkBox2 = findViewById(R.id.checkBox2)
        radioGroup = findViewById(R.id.radioGroup)
        radioButton1 = findViewById(R.id.radioButton1)
        radioButton2 = findViewById(R.id.radioButton2)
        switchButton1 = findViewById(R.id.switch1)
        switchButton2 = findViewById(R.id.switch2)
        chip1 = findViewById(R.id.chip)
        chip2 = findViewById(R.id.chip2)
        chip3 = findViewById(R.id.chip3)
        floatingActionButton = findViewById(R.id.floatingActionButtons)
        ratingBar = findViewById(R.id.ratingBar)
        seekBarSlide = findViewById(R.id.seekBar)
        toggleButton1 = findViewById(R.id.toggleButton1)
        toggleButton2 = findViewById(R.id.toggleButton2)
        datePickerButton = findViewById(R.id.datePickerButton)
        timePickerButton = findViewById(R.id.timePickerButton)

        checkBox1?.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                // Do something when the checkbox is checked
                Log.e(isChecked.toString(), "hii")
            }else{
                // Do something when the checkbox is unchecked
                Log.e(isChecked.toString(), "hii")
            }
        }

        checkBox2?.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                // Do something when the checkbox is checked
                Log.e(isChecked.toString(), "hii")
            }else{
                // Do something when the checkbox is unchecked
                Log.e(isChecked.toString(), "hii")
            }
        }

        radioGroup?.setOnCheckedChangeListener{_, isChecked ->
            when(isChecked){
                R.id.radioButton1 -> {

                }
                R.id.radioButton2 -> {

                }
            }
        }

        switchButton1?.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                // Do something when the checkbox is checked
                Log.e(isChecked.toString(), "switchButton1")
            }else{
                // Do something when the checkbox is unchecked
                Log.e(isChecked.toString(), "switchButton1")
            }
        }

        switchButton2?.setOnCheckedChangeListener{_, isChecked ->
            if(isChecked){
                // Do something when the checkbox is checked
                Log.e(isChecked.toString(), "switchButton2")
            }else{
                // Do something when the checkbox is unchecked
                Log.e(isChecked.toString(), "switchButton2")
            }
        }

        chip1?.setOnClickListener {
            // Do something when the chip is clicked
            Log.e("Chip 1 on Clicked", "chip 1")
        }

        chip2?.setOnClickListener {
            // Do something when the chip is clicked
            Log.e("Chip 2 on Clicked", "chip 2")
        }

        chip3?.setOnClickListener {
            // Do something when the chip is clicked
            Log.e("Chip 3 on Clicked", "chip 3")
        }

        floatingActionButtons.setOnClickListener{
            // Do something when the Floating Action Button is clicked
            Log.e("FAB on Clicked", "Floating Action Button")
        }

        ratingBar?.setOnRatingBarChangeListener { _, rating, _ ->
            // Handle the rating change event
            // You can do something with the new rating value here
            Log.e("Rating", rating.toString())
        }

        seekBarSlide?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@SmallWidgetActivity, "Progress: $progress", Toast.LENGTH_SHORT).show()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Log.e("seekbar Start", seekBar.toString())
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Log.e("seekbar Stop", seekBar.toString())
            }
        })

        toggleButton1?.setOnClickListener{
            // Do something when the Toggle Button is clicked
            Log.e("Toggle on Clicked", "Toggle Button 1")
        }

        toggleButton2?.setOnClickListener{
            // Do something when the Toggle Button is clicked
            Log.e("Toggle on Clicked", "Toggle Button 2")
        }

        datePickerButton?.setOnClickListener{
            // Get the current date to set as the default date in the date picker
            val calender = Calendar.getInstance()
            val year = calender.get(Calendar.YEAR)
            val month = calender.get(Calendar.MONTH)
            val day = calender.get(Calendar.DAY_OF_MONTH)

            // Create a date picker dialog and set the initial date
            val datePickerDialog = DatePickerDialog(
                this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    // Handle the selected date here (e.g., display in a TextView)
                    val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                    // textView.text = selectedDate (use a TextView to display the selected date)

                    Log.e(selectedDate,"selected Date")
                },
                year,
                month,
                day
            )

            datePickerDialog.show()
        }


        timePickerButton?.setOnClickListener{
            // Get the current time to set as the default time in the time picker
            val calendar = Calendar.getInstance()
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            // Create a time picker dialog and set the initial time
            val timePickerDialog = TimePickerDialog(
                this,
                { _, selectedHour, selectedMinute ->
                    // Handle the selected time here (e.g., display in a TextView)
                    val selectedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                    // textView.text = selectedTime (use a TextView to display the selected time)

                    Log.e(selectedTime,"selected Time")
                },
                hour,
                minute,
                true // true for 24-hour format, false for 12-hour format
            )

            // Show the time picker dialog
            timePickerDialog.show()
        }


    }
}

