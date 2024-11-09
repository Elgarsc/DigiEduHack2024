// app/src/main/java/com/example/eklasewidgetprototype/MainActivity.kt

package com.example.eklasewidgetprototype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // Access elements by their IDs
        val leaderboardTitle = findViewById<TextView>(R.id.leaderboardTitle)
        val progressBarMath = findViewById<ProgressBar>(R.id.progressBarMath)
        val progressBarEnglish = findViewById<ProgressBar>(R.id.progressBarEnglish)


        // Example: Set progress on the progress bars
        progressBarMath.progress = 75 // Set the progress for Math
        progressBarMath.max = 100
        progressBarEnglish.progress = 50 // Set the progress for English
        progressBarEnglish.max = 100
    }
}

