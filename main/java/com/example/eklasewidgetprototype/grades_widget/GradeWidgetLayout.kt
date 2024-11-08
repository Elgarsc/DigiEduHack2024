// app/src/main/java/com/example/eklasewidgetprototype/widget/GradeWidgetLayout.kt
package com.example.eklasewidgetprototype.grades_widget

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import android.view.LayoutInflater
import com.example.eklasewidgetprototype.R
import com.example.eklasewidgetprototype.model.GradeEntry

class GradeWidgetLayout(context: Context, private val gradeEntry: GradeEntry) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        LayoutInflater.from(context).inflate(R.layout.grade_item_layout, this, true)
        setUpGradeEntry()
    }

    private fun setUpGradeEntry() {
        findViewById<TextView>(R.id.subjectTextView).text = gradeEntry.subject
        findViewById<TextView>(R.id.dateTextView).text = gradeEntry.date
        findViewById<TextView>(R.id.scoreTextView).text = gradeEntry.score
    }
}