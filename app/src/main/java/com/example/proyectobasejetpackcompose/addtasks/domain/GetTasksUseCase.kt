package com.example.proyectobasejetpackcompose.addtasks.domain

import com.example.proyectobasejetpackcompose.addtasks.data.TaskRepository
import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTasksUseCase @Inject constructor(private val tasksRepository: TaskRepository) {
    operator fun invoke(): Flow<List<TasksModel>> = tasksRepository.tasks
}