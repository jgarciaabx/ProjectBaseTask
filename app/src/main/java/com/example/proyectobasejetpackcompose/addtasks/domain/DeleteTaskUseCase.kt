package com.example.proyectobasejetpackcompose.addtasks.domain

import com.example.proyectobasejetpackcompose.addtasks.data.TaskRepository
import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel
import javax.inject.Inject

class DeleteTaskUseCase @Inject constructor(private val taskRepository: TaskRepository){
    suspend operator fun invoke(tasksModel: TasksModel){
        taskRepository.delete(tasksModel)
    }
}