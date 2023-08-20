package com.cdr.practicetaskjetpackcomposearticle.presentation.menu

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun MenuContent(activity: Activity, viewModel: MenuViewModel) {
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Практическое задание",
                    maxLines = 1,
                    color = colorScheme.onPrimary,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = colorScheme.secondary)
        )
    }) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(modifier = Modifier.padding(bottom = 10.dp), text = "Выберите доступное действие:")
            Button(
                onClick = { viewModel.launchAllEmployeesScreen(activity) },
                modifier = Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Все сотрудники компании")
            }
            Button(
                onClick = { viewModel.launchNewEmployeeScreen(activity) },
                modifier = Modifier.width(300.dp),
                colors = ButtonDefaults.buttonColors(containerColor = colorScheme.secondary),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Добавить сотрудника компании")
            }
        }
    }
}