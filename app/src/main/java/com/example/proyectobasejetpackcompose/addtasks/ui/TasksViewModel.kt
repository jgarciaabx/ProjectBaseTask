package com.example.proyectobasejetpackcompose.addtasks.ui

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectobasejetpackcompose.addtasks.domain.AddTaskUseCase
import com.example.proyectobasejetpackcompose.addtasks.domain.DeleteTaskUseCase
import com.example.proyectobasejetpackcompose.addtasks.domain.GetTasksUseCase
import com.example.proyectobasejetpackcompose.addtasks.domain.UpdateTaskUseCase
import com.example.proyectobasejetpackcompose.addtasks.ui.TasksUiState.*
import com.example.proyectobasejetpackcompose.addtasks.ui.model.TasksModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TasksViewModel @Inject constructor(
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase,
    getTasksUseCase: GetTasksUseCase
) : ViewModel() {


    val uiState:StateFlow<TasksUiState> = getTasksUseCase().map (::Success)
        .catch { Error(it) }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), Loading)

    private val _showDialog = MutableLiveData<Boolean>()
    val showDialog: LiveData<Boolean> = _showDialog

//    private val _tasks = mutableStateListOf<TasksModel>()
//    val tasks:List<TasksModel> = _tasks

    fun onDialogClose() {
        _showDialog.value = false
    }

    fun onTasksCreated(task: String) {
        _showDialog.value = false

        viewModelScope.launch {
            addTaskUseCase(TasksModel(task= task))
        }

    }

    fun onDialogClick() {
        _showDialog.value = true
    }

    fun onCheckBoxSelected(tasksModel: TasksModel) {
        viewModelScope.launch {
            updateTaskUseCase(tasksModel.copy(selected = !tasksModel.selected))
        }
    }

    fun onItemRemove(tasksModel: TasksModel) {
        viewModelScope.launch {
            deleteTaskUseCase(tasksModel)
        }
    }
}