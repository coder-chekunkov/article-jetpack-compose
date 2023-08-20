package com.cdr.practicetaskjetpackcomposearticle.presentation.newEmployee

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cdr.practicetaskjetpackcomposearticle.data.Position

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun NewEmployeeContent(activity: Activity, viewModel: NewEmployeeViewModel) {
    val positions = listOf(Position.JUNIOR, Position.MIDDLE, Position.SENIOR, Position.ARCHITECT)

    var nameField by remember { mutableStateOf("") }
    var surnameField by remember { mutableStateOf("") }
    var positionField by remember { mutableStateOf(positions[0]) }

    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = "Новый сотрудник",
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                contentAlignment = Alignment.TopCenter,
            ) {
                Image(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = "New Employee Image",
                    modifier = Modifier.size(100.dp),
                    colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.secondary)
                )
            }
            Text(
                text = "Для создания нового сотрудника - заполните все данные. ",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            TextField(
                value = nameField,
                onValueChange = { newText ->
                    nameField = newText
                },
                modifier = Modifier
                    .width(width = 300.dp)
                    .padding(top = 16.dp),
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Black,
                    disabledTextColor = Transparent,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent
                ),
                supportingText = { Text(text = "Имя сотрудника") }
            )
            TextField(
                value = surnameField,
                onValueChange = { newText ->
                    surnameField = newText
                },
                modifier = Modifier
                    .width(width = 300.dp)
                    .padding(top = 12.dp),
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Black,
                    disabledTextColor = Transparent,
                    focusedIndicatorColor = Transparent,
                    unfocusedIndicatorColor = Transparent,
                    disabledIndicatorColor = Transparent
                ),
                supportingText = { Text(text = "Фамилия сотрудника") }
            )
            Column(
                modifier = Modifier
                    .selectableGroup()
                    .padding(16.dp)
            ) {
                positions.forEach { position ->
                    Row(
                        modifier = Modifier.height(30.dp),
                        verticalAlignment = Alignment.CenterVertically
                    )
                    {
                        RadioButton(
                            selected = (position == positionField),
                            onClick = { positionField = position }
                        )
                        Text(
                            modifier = Modifier.clickable { positionField = position },
                            text = position.positionName,
                            fontSize = 18.sp
                        )
                    }
                }
            }
            Button(
                onClick = { },
                modifier = Modifier
                    .width(300.dp)
                    .padding(top = 12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
                shape = MaterialTheme.shapes.medium
            ) {
                Text(text = "Добавить сотрудника компании")
            }
        }

    }
}
