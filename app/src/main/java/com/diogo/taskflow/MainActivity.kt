package com.diogo.taskflow

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.diogo.taskflow.MainActivity.Companion.TASKSERVICE
import com.diogo.taskflow.model.task.Task
import com.diogo.taskflow.model.task.service.TaskServiceImpl
import com.diogo.taskflow.ui.theme.TaskFlowTheme
import kotlin.coroutines.coroutineContext

class MainActivity : ComponentActivity() {

    companion object {

        val TASKSERVICE = TaskServiceImpl()

    }

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface (color = MaterialTheme.colorScheme.background){

                    TaskFlowContent()

                }

            }
        }
    }
}

@RequiresApi(64)
@Composable
fun TaskFlowContent() {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(Color.White)
    ) {

        var showCustomDialogWithResult by remember { mutableStateOf(false) }

        header {
            showCustomDialogWithResult = !showCustomDialogWithResult
        }

        if (showCustomDialogWithResult) {
            dialog(
                onDismiss = {
                    showCustomDialogWithResult = !showCustomDialogWithResult
                },
                onNegativeClick = {
                    showCustomDialogWithResult = !showCustomDialogWithResult
                },
                onPositiveClick = { name, description, date ->
                    showCustomDialogWithResult = !showCustomDialogWithResult
                    TASKSERVICE.put(Task(name, description, date))
                }
            )
        }

        taskPanel(TASKSERVICE)
    }
}