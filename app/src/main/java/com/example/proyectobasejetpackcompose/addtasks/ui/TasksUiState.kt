package com.example.proyectobasejetpackcompose.addtasks.ui

import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel

sealed interface TasksUiState{
    object Loading:TasksUiState
    data class Error(val throwable: Throwable): TasksUiState
    data class Success(val tasks:List<TasksModel>) : TasksUiState
}