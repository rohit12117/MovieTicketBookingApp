package com.example.moviebooking

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class AlarmBroad : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent){
        val mp = MediaPlayer.create(context, R.raw.softcore)
        Log.d("Hello", "Repeating alarm")
        mp.start()
        Toast.makeText(context, "Alarm Ringing", Toast.LENGTH_LONG).show()
    }
}