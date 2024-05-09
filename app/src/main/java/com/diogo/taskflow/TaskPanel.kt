package com.diogo.taskflow

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import com.diogo.taskflow.model.task.Task
import com.diogo.taskflow.model.task.service.TaskService

@Composable
fun taskPanel(taskService: TaskService){

    val tasks = remember { setOf<Task>().toMutableStateList() }

    LaunchedEffect(taskService) {
        taskService.setOnTaskAddListener {
            tasks.add(it)
        }
        taskService.setOnTaskRemoveListener {
            tasks.remove(it)
        }
    }

    LazyColumn(
        contentPadding = PaddingValues(all = 24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items = tasks){ task ->
            taskItem(task)
        }
    }

}