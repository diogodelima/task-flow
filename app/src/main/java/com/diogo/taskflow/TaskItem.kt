package com.diogo.taskflow

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.diogo.taskflow.model.task.Task
import com.diogo.taskflow.ui.theme.addBackground
import com.diogo.taskflow.ui.theme.taskBackground
import java.time.LocalDate

@SuppressLint("NewApi")
@Composable
fun TaskItem(task: Task){

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(taskBackground),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Column(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 16.dp)
        ) {

            Text(
                text = task.name,
                color = Color.White,
                fontSize = 18.sp
            )
            Text(
                text = task.description,
                color = Color.White,
                fontSize = 12.sp
            )

        }

        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = task.getFormattedDate(),
                color = Color.White,
                fontSize = 14.sp
            )

            Box(
                modifier = Modifier
                    .width(32.dp)
                    .height(32.dp)
                    .padding(start = 5.dp)
            ) {
                IconButton(
                    onClick = {
                        MainActivity.TASKSERVICE.remove(task)
                        Log.d("MainActivity", "${MainActivity.TASKSERVICE.getAll().size}")
                    },
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = Icons.Rounded.Delete,
                        contentDescription = "Delete task",
                        tint = Color.Red
                    )
                }
            }

        }

    }

}

@SuppressLint("NewApi")
@Composable
@Preview
fun TaskItemPreview(){
    TaskItem(task = Task("Exame", "Telecomunicações II", LocalDate.of(2024, 6, 22)))
}