package com.example.proyectobasejetpackcompose.addtasks.data

import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val tasks: Flow<List<TasksModel>> = taskDao.getTasks().map {
        items -> items.map {TasksModel(it.id, it.task , it.selected)}
    }

    suspend fun add(tasksModel: TasksModel){
        taskDao.addTask(tasksModel.toData())
    }

    suspend fun update(tasksModel: TasksModel){
        taskDao.updateTask(tasksModel.toData())
    }

    suspend fun delete(tasksModel: TasksModel){
        taskDao.deleteTask(tasksModel.toData())
    }
}

fun TasksModel.toData():TaskEntity{
    return TaskEntity(this.id, this.task, this.selected)
}