// app/src/main/java/com/example/eklasewidgetprototype/widget/ClassesWidgetProvider >

package com.example.eklasewidgetprototype.classes_widget

import android.app.AlarmManager
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.RemoteViews
import com.example.eklasewidgetprototype.R
import com.example.eklasewidgetprototype.model.ClassesEntry

class ClassesWidgetProvider : AppWidgetProvider() {

    companion object {
        const val ACTION_ADD_ENTRY = "com.example.eklasewidgetprototype.ADD_ENTRY"

        private val classesList = mutableListOf(
            ClassesEntry("", "", "", "", false),
        )
    }


    override fun onReceive(context: Context, intent: Intent) {
        super.onReceive(context, intent)
        if (intent.action == ACTION_ADD_ENTRY) {
            newClassesEntry()
            val appWidgetManager = AppWidgetManager.getInstance(context)
            val appWidgetIds = appWidgetManager.getAppWidgetIds(
                ComponentName(context, ClassesWidgetProvider::class.java)
            )
            onUpdate(context, appWidgetManager, appWidgetIds)
        }
    }



    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        for (appWidgetId in appWidgetIds) {
            val views = RemoteViews(context.packageName, R.layout.classes)

            val addEntryIntent = Intent(context, ClassesWidgetProvider::class.java).apply {
                action = ACTION_ADD_ENTRY
            }
            val addEntryPendingIntent = PendingIntent.getBroadcast(
                context, 0, addEntryIntent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
            )
            views.setOnClickPendingIntent(R.id.updateButton, addEntryPendingIntent)

            updateWidgetViews(views, context)
            appWidgetManager.updateAppWidget(appWidgetId, views)
        }
    }

    private fun updateWidgetViews(views: RemoteViews, context: Context) {
        views.removeAllViews(R.id.classes_container)
        if (classesList.isNotEmpty()) {
            views.setTextViewText(R.id.classesDateTextView, classesList[0].date)
        }

        for (entry in classesList) {
            val classView = RemoteViews(context.packageName, R.layout.classes_item_layout)
            classView.setTextViewText(R.id.subjectTextView, entry.subject)
            classView.setTextViewText(R.id.nrTextView, entry.nr)
            classView.setTextViewText(R.id.homeworkTextView, entry.homework)
            classView.setTextViewText(R.id.testTextView, if (entry.test) "✅" else "")

            views.addView(R.id.classes_container, classView)
        }
    }

    private fun newClassesEntry() {
        classesList.clear()
        for (entry in getClasses()) {
            classesList.add(entry)
        }

    }
    private fun getClasses(): List<ClassesEntry> {
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

