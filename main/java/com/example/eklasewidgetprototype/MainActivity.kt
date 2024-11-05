// app/src/main/java/com/example/eklasewidgetprototype/MainActivity.kt

package com.example.eklasewidgetprototype

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RemoteViews
import android.widget.Switch
import android.widget.TextView
import androidx.compose.material3.darkColorScheme
import com.example.eklasewidgetprototype.widget.GradeWidgetProvider

class MainActivity : AppCompatActivity() {

    private lateinit var darkModeSwitch: Switch
    private lateinit var textView: TextView
    private lateinit var updateWidgetButton: Button
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var rootLayout: LinearLayout

    // Key for shared preferences
    private val DARK_MODE_KEY = "dark_mode"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize views
        darkModeSwitch = findViewById(R.id.dark_mode_switch) // Ensure this is in your layout
        textView = findViewById(R.id.text_view)
        updateWidgetButton = findViewById(R.id.update_widget_button)
        rootLayout = findViewById(R.id.root_layout)

        // Initialize shared preferences
        sharedPreferences = getSharedPreferences("app_preferences", MODE_PRIVATE)

        // Set up the button click to update the widget in real-time
        updateWidgetButton.setOnClickListener {
            // Get the current dark mode state and update the widget
            val isDarkMode = darkModeSwitch.isChecked
            updateWidget(isDarkMode)
        }
    }

    private fun updateUI(isDarkMode: Boolean) {
        // Set background and text colors based on the mode
        val backgroundColor = if (isDarkMode) {
            ContextCompat.getColor(this, R.color.black) // Dark mode background
        } else {
            ContextCompat.getColor(this, R.color.white) // Light mode background
        }

        val textColor = if (isDarkMode) {
            ContextCompat.getColor(this, R.color.white) // Dark mode text
        } else {
            ContextCompat.getColor(this, R.color.black) // Light mode text
        }


        // Update the background and text colors
        rootLayout.setBackgroundColor(backgroundColor)
        textView.setTextColor(textColor)
    }

    private fun updateWidget(isDarkMode: Boolean) {
        // Update the UI and the widget with the specified mode
        updateUI(isDarkMode)
        val appWidgetManager = AppWidgetManager.getInstance(this)
        val widgetProvider = ComponentName(this, GradeWidgetProvider::class.java)
        val appWidgetIds = appWidgetManager.getAppWidgetIds(widgetProvider)

        if (isDarkMode) {
            val textColor = ContextCompat.getColor(this, R.color.black)
            val backgroundColor = ContextCompat.getColor(this, R.color.white)
        }else{
            val textColor = ContextCompat.getColor(this, R.color.white)
            val backgroundColor = ContextCompat.getColor(this, R.color.black)
        }
        // Get the background and text colors from resources
        val backgroundColor = if (isDarkMode) {
            ContextCompat.getColor(this, R.color.background_color) // Dark mode background
        } else {
            ContextCompat.getColor(this, R.color.background_color) // Light mode background
        }

        val textColor = if (isDarkMode) {
            ContextCompat.getColor(this, R.color.text_color) // Dark mode text
        } else {
            ContextCompat.getColor(this, R.color.text_color) // Light mode text
        }


        // Update each widget instance
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(packageName, R.layout.grades)

            // Set the background color for the container
            views.setInt(R.id.grades_container, "setBackgroundColor", backgroundColor)
            views.setInt(R.id.scoreTextView, "setBackgroundColor", backgroundColor)

            // Update the text color for each TextView in the widget
            views.setTextColor(R.id.subjectTextView, textColor)
            views.setTextColor(R.id.dateTextView, textColor)
            views.setTextColor(R.id.scoreTextView, textColor)

            // Update the widget
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }
}

