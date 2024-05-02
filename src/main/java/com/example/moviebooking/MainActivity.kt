package com.example.moviebooking

import android.annotation.SuppressLint
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnlala = findViewById<ImageButton>(R.id.btnlala)
        val btnJoker = findViewById<ImageButton>(R.id.btnJoker)
        val btnBlade = findViewById<ImageButton>(R.id.btnBlade)
        val btnlunch = findViewById<ImageButton>(R.id.btnlunch)

        btnlala.setOnClickListener {
            Intent(this, Movie1::class.java).apply{
                startActivity(this)
            }
        }

        btnlunch.setOnClickListener {
            Intent(this, Movie2::class.java).apply{
                startActivity(this)
            }
        }

        btnJoker.setOnClickListener {
            Intent(this, Movie3::class.java).apply{
                startActivity(this)
            }
        }

        btnBlade.setOnClickListener {
            Intent(this, Movie4::class.java).apply{
                startActivity(this)
            }
        }


    }
}
