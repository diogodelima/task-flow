package com.diogo.taskflow.model.task

import android.annotation.SuppressLint
import java.time.LocalDate
import java.time.format.DateTimeFormatter

data class Task(

    val name: String,
    val description: String,
    val date: LocalDate

){

    @SuppressLint("NewApi")
    fun getFormattedDate() : String {
        val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        return formatter.format(this.date)
    }

}