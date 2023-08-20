package com.cdr.practicetaskjetpackcomposearticle.presentation.allEmployees

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.cdr.practicetaskjetpackcomposearticle.data.EmployeeRepository
import com.cdr.practicetaskjetpackcomposearticle.ui.theme.EmployeeContent
import com.cdr.practicetaskjetpackcomposearticle.presentation.allEmployees.AllEmployeesViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun AllEmployeesContent(activity: Activity, viewModel: AllEmployeesViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Все сотрудники",
                    maxLines = 1,
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )
            },
            navigationIcon = {
                IconButton(onClick = { activity.finish() }) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = MaterialTheme.colorScheme.secondary)
        )
    }) { innerPadding ->
        val allEmployees = remember { EmployeeRepository().getAllEmployees() }
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            itemsIndexed(allEmployees) { _, employee ->
                EmployeeContent(employee = employee)
            }
        }
    }
}