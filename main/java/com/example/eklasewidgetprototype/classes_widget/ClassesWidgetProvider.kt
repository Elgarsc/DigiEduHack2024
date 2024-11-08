// app/src/main/java/com/example/eklasewidgetprototype/widget/ClassesWidgetProvider >

package com.example.eklasewidgetprototype.classes_widget

import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.util.Log
import android.widget.RemoteViews
import com.example.eklasewidgetprototype.R
import com.example.eklasewidgetprototype.model.ClassesEntry

class ClassesWidgetProvider : AppWidgetProvider() {

    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        Log.d("ClassesWidgetProvider", "onUpdate called with appWidgetIds: ${appWidgetIds.joinToString()}")
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.classes)
            updateWidgetViews(views, context)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    private fun updateWidgetViews(views: RemoteViews, context: Context) {
        Log.d("ClassesWidgetProvider", "updateWidgetViews called")

        val classes = getClasses()
        Log.d("ClassesWidgetProvider", "Fetched classes: $classes")

        // Ensure views are being removed properly
        views.removeAllViews(R.id.classes_container)
        Log.d("ClassesWidgetProvider", "Removed all views from classes_container")

        // Add date to the widget
        val dateView = RemoteViews(context.packageName, R.layout.classes)
        if (classes.isNotEmpty()) {
            dateView.setTextViewText(R.id.dateTextView, classes[0].date)
            Log.d("ClassesWidgetProvider", "Set dateTextView with date: ${classes[0].date}")
        } else {
            Log.d("ClassesWidgetProvider", "No classes available to set dateTextView")
        }

        // Add each class item to the container
        for (x in classes) {
            val classesView = RemoteViews(context.packageName, R.layout.classes_item_layout)
            classesView.setTextViewText(R.id.subjectTextView, x.subject)
            classesView.setTextViewText(R.id.nrTextView, x.nr)
            classesView.setTextViewText(R.id.homeworkTextView, x.homework)
            classesView.setTextViewText(R.id.testTextView, if (x.test) "✅" else "         ")

            Log.d("ClassesWidgetProvider", "Adding class: ${x.subject} with nr: ${x.nr}, homework: ${x.homework}, test: ${x.test}")

            views.addView(R.id.classes_container, classesView)
        }
    }

    private fun getClasses(): List<ClassesEntry> {
        // Example data for testing
        return listOf(
            ClassesEntry("11.8.2024", "1.", "English", "reading pg 1-10", false),
            ClassesEntry("11.8.2024", "2.", "Math", "", false),
            ClassesEntry("11.8.2024", "3.", "Math", "", true),
            ClassesEntry("11.8.2024", "4", "Geography", "Open a map", false),
            ClassesEntry("11.8.2024", "5.", "Spanish", "", false),
            ClassesEntry("11.8.2024", "6.", "Physics", "", true),
            ClassesEntry("11.8.2024", "7.", "Physics", "", false),
            ClassesEntry("11.8.2024", "8.", "Physics", "", false),

        )
    }
}
