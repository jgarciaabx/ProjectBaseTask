package com.example.proyectobasejetpackcompose.addtasks.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel
import javax.inject.Inject


class TasksViewModel @Inject constructor() : ViewModel() {


    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

    private val _tasks = mutableStateListOf<TasksModel>()

    val tasks:List<TasksModel> = _tasks

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTasksCreated(task: String) {
        _showDialog.value = false
        _tasks.add(TasksModel(task = task))
    }

    fun onDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(tasksModel: TasksModel) {
            val index = _tasks.indexOf(tasksModel)
            _tasks[index] = _tasks[index].let {
                it.copy(selected = !it.selected)
            }
    }

    fun onItemRemove(tasksModel: TasksModel) {
            val task = _tasks.find { it.id == tasksModel.id }
            _tasks.remove(task)
    }
}