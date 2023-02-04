package com.example.proyectobasejetpackcompose.addtasks.domain

import com.example.proyectobasejetpackcompose.addtasks.data.TaskRepository
import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel
import javax.inject.Inject

class UpdateTaskUseCase  @Inject constructor(private val taskRepository: TaskRepository) {
    suspend operator fun invoke(tasksModel: TasksModel) {
        taskRepository.update(tasksModel)
    }
}