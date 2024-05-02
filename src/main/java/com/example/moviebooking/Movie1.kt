package com.example.moviebooking

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.DatePickerDialog
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class Movie1 : AppCompatActivity() {

    var formatDate = SimpleDateFormat("dd MMMM YYYY", Locale.US)
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie1)
        val btnDate = findViewById<Button>(R.id.btnDate)

        btnDate.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, android.R.style.Theme_Holo_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->

                val selectDate = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)
                val date = formatDate.format(selectDate.time)
                Toast.makeText(this, "DATE: " + date, Toast.LENGTH_LONG).show()

            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        val btnTime = findViewById<Button>(R.id.btnTime)
        var alarmManager: AlarmManager
        val intent = Intent(this, AlarmBroad::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 234, intent,
            PendingIntent.FLAG_IMMUTABLE)

        var tv = findViewById<TextView>(R.id.tv)
        var etText = findViewById<EditText>(R.id.etText)
//      Putting the time picker
        btnTime.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Toast.makeText(this, "TIME: "+ SimpleDateFormat("HH:mm").format(cal.time), Toast.LENGTH_LONG).show()

            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE),true).show()




        }

        val btntrail = findViewById<Button>(R.id.btnTrail)

        btntrail.setOnClickListener {
            Intent(this, Trailer::class.java).apply{
                startActivity(this)
            }
        }

        val btnBook = findViewById<Button>(R.id.btnBook)
        btnBook.setOnClickListener {

            var i = etText.text.toString().toInt()
            alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager

            alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (i*1000), pendingIntent)
            Toast.makeText(this, "Movie is Booked and Alarm set for $i seconds", Toast.LENGTH_LONG).show()
        }



    }
}