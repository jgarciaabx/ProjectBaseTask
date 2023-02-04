package com.example.proyectobasejetpackcompose.addtasks.ui.model

data class TasksModel(val id:Int = System.currentTimeMillis().hashCode(),val task: String, var selected:Boolean = false)