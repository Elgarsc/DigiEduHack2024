# DigiEduHack2024

Grades Widget (OOP)
This project is an Android widget that allows users to view their latest grades. The widget displays grades, subjects, and dates. 

Input
Navigate to app/src/main/java/com/example/eklasewidgetprototype/widget/GradeWidgetProvider.kt

Example
```
private fun getGrades(): List<GradeEntry> {
        // Implement your logic to fetch grades
        return listOf(
            GradeEntry("Programmēšana II", "08.10.", "100%"),            //
            GradeEntry("Kultūra un māksla I (mūzika)", "02.10.", "10"),  // Input your latest grades here
            GradeEntry("Matemātika II", "01.11.", "9"),                  //
        )
    }
```


