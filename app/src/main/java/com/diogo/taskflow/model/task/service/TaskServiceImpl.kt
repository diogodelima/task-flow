package com.diogo.taskflow.model.task.service

import com.diogo.taskflow.model.task.Task

class TaskServiceImpl(

    private val cache: MutableSet<Task> = HashSet()

) : TaskService {

    private var onTaskAddListener: ((Task) -> Unit)? = null
    private var onTaskRemoveListener: ((Task) -> Unit)? = null

    override fun put(task: Task) {
        this.cache.add(task)
        notifyTaskAdded(task)
    }

    override fun remove(task: Task) {
        this.cache.remove(task)
        notifyTaskRemoved(task)
    }

    override fun getAll(): Set<Task> {
        return this.cache
    }

    override fun setOnTaskAddListener(listener: (Task) -> Unit) {
        onTaskAddListener = listener
    }

    override fun setOnTaskRemoveListener(listener: (Task) -> Unit) {
        onTaskRemoveListener = listener
    }

    private fun notifyTaskRemoved(task: Task){
        onTaskRemoveListener?.invoke(task)
    }

    private fun notifyTaskAdded(task: Task){
        onTaskAddListener?.invoke(task)
    }

}