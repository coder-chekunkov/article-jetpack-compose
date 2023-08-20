package com.cdr.practicetaskjetpackcomposearticle.ui.theme

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cdr.practicetaskjetpackcomposearticle.data.Employee
import com.cdr.practicetaskjetpackcomposearticle.data.Position


@Composable
internal fun EmployeeContent(employee: Employee) {
    Box {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp, top = 10.dp, bottom = 2.dp)
        ) {
            AsyncImage(
                model = employee.photo,
                contentDescription = employee.surname,
                modifier = Modifier.size(45.dp).clip(CircleShape),
                contentScale = ContentScale.Crop,
                placeholder = rememberVectorPainter(Icons.Filled.AccountCircle),
                error = rememberVectorPainter(Icons.Filled.AccountCircle)
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "${employee.name} ${employee.surname}",
                    style = MaterialTheme.typography.titleMedium,
                )
                Text(
                    text = employee.position.positionName, color = Color.DarkGray
                )
            }
        }
    }
}

@Preview
@Composable
private fun EmployeeContentPreview() {
    EmployeeContent(
        employee = Employee(
            id = -1, photo = "", name = "Иван", surname = "Иванов", position = Position.MIDDLE
        )
    )
}