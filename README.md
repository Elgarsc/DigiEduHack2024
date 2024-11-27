# Link to our video pitch
https://www.youtube.com/watch?v=Y88-rE55XZ0&ab_channel=Mat%C4%ABssMeiers


# DigiEduHack2024

Grades Widget (OOP)
This project is an Android widget that allows users to view their latest grades. The widget displays grades, subjects, and dates. 

Input:
Navigate to 

```app/src/main/java/com/example/eklasewidgetprototype/widget/GradeWidgetProvider.kt```

or 

```app/src/main/java/com/example/eklasewidgetprototype/widget/ClassesWidgetProvider.kt```

Examples:
```kt
private fun getGrades(): List<GradeEntry> {
        // Implement your logic to fetch grades
        return listOf(
            GradeEntry("Programmēšana II", "08.10.", "100%"),            //
            GradeEntry("Kultūra un māksla I (mūzika)", "02.10.", "10"),  // Input your latest grades here
            GradeEntry("Matemātika II", "01.11.", "9"),                  //
        )
    }
```
```kt
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
```
![image](https://github.com/user-attachments/assets/ff52c59e-4554-4d62-9e83-b7badfd98b45)





