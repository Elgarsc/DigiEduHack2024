// app/src/main/java/com/example/eklasewidgetprototype/widget/GradeWidgetProvider.kt >

package com.example.eklasewidgetprototype.grades_widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.widget.RemoteViews
import com.example.eklasewidgetprototype.R
import com.example.eklasewidgetprototype.model.GradeEntry

class GradeWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.grades)
            updateWidgetViews(views, context)
            appWidgetManager.updateAppWidget(appWidgetId, views)

            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    private fun updateWidgetViews(views: RemoteViews, context: Context) {
        val grades = getGrades() // Your method to retrieve grades

        views.removeAllViews(R.id.grades_container) // Clear previous views

        for (grade in grades) {
            // Create a new GradeWidgetLayout for each grade
            val gradeView = RemoteViews(context.packageName, R.layout.grade_item_layout)

            gradeView.setTextViewText(R.id.subjectTextView, grade.subject)
            gradeView.setTextViewText(R.id.dateTextView, grade.date)
            gradeView.setTextViewText(R.id.scoreTextView, grade.score)

            // Add the grade view to the container
            views.addView(R.id.grades_container, gradeView)
        }
    }

    private fun getGrades(): List<GradeEntry> {
        // Implement your logic to fetch grades
        return listOf(
            GradeEntry("Programmēšana II", "08.10.", "100%"),
            GradeEntry("Kultūra un māksla I (mūzika)", "02.10.", "10"),
            GradeEntry("Matemātika II", "01.11.", "9"),
        )
    }
}
