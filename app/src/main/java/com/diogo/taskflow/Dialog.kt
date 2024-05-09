package com.diogo.taskflow

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@RequiresApi(0)
@Composable
fun dialog(
            onDismiss: () -> Unit,
            onNegativeClick: () -> Unit,
            onPositiveClick: (name: String, description: String, date: LocalDate) -> Unit
){
    
    Dialog(onDismissRequest = onDismiss) {

        var name by remember { mutableStateOf("") }
        var description by remember { mutableStateOf("") }
        var dateString by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(vertical = 5.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            OutlinedTextField(
                value = name,
                label = { Text("Nome", color = Color.White) },
                onValueChange = { name = it },
            )

            OutlinedTextField(
                value = description,
                label = { Text("Descrição", color = Color.White) },
                onValueChange = { description = it },
            )

            OutlinedTextField(
                value = dateString,
                label = { Text("Data", color = Color.White) },
                onValueChange = { dateString = it },
            )

            Row(
                horizontalArrangement = Arrangement.End,
                modifier = Modifier.fillMaxWidth()
            ) {

                TextButton(onClick = onNegativeClick) {
                    Text(text = "CANCEL")
                }
                Spacer(modifier = Modifier.width(4.dp))
                TextButton(onClick = {
                    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val date = LocalDate.parse(dateString, formatter)
                    onPositiveClick(name, description, date)
                }) {
                    Text(text = "OK")
                }
            }

        }

    }

}