package com.cdr.practicetaskjetpackcomposearticle.presentation.menu

import android.app.Activity
import androidx.lifecycle.ViewModel
import com.cdr.practicetaskjetpackcomposearticle.presentation.allEmployees.AllEmployeesActivity
import com.cdr.practicetaskjetpackcomposearticle.presentation.newEmployee.NewEmployeeActivity

class MenuViewModel : ViewModel() {

    fun launchAllEmployeesScreen(activity: Activity) =
        activity.startActivity(AllEmployeesActivity.newIntent(activity))

    fun launchNewEmployeeScreen(activity: Activity) =
        activity.startActivity(NewEmployeeActivity.newIntent(activity))
}
