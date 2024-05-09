package com.diogo.taskflow.model.task.service

import com.diogo.taskflow.model.task.Task

interface TaskService {

    fun put(task: Task)

    fun remove(task: Task)

    fun getAll() : Set<Task>

    fun setOnTaskAddListener(listener: (Task) -> Unit)

    fun setOnTaskRemoveListener(listener: (Task) -> Unit)

}