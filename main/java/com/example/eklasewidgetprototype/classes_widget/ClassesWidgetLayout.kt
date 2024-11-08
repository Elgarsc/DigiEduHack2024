// app/src/main/java/com/example/eklasewidgetprototype/widget/ClassesWidgetLayout.kt

package com.example.eklasewidgetprototype.classes_widget

import android.content.Context
import android.widget.LinearLayout
import android.widget.TextView
import android.view.LayoutInflater
import com.example.eklasewidgetprototype.R
import com.example.eklasewidgetprototype.model.ClassesEntry



class ClassesWidgetLayout(context: Context, private val classesEntry: ClassesEntry) : LinearLayout(context) {

    init {
        orientation = HORIZONTAL
        LayoutInflater.from(context).inflate(R.layout.classes_item_layout, this, true)
        setUpClassesEntry()
    }

    private fun setUpClassesEntry() {
        findViewById<TextView>(R.id.subjectTextView).text = classesEntry.subject
        findViewById<TextView>(R.id.nrTextView).text = classesEntry.nr
        findViewById<TextView>(R.id.homeworkTextView).text = classesEntry.homework
        findViewById<TextView>(R.id.testTextView).text = classesEntry.test.toString()
    }
}