package com.example.todo.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todo.Task
import com.example.todo.TaskDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel  // 생성자 주입방식으로 정의
class MainViewModel @Inject constructor(private val taskDao: TaskDao) : ViewModel() {
    var title by mutableStateOf("")
    var description by mutableStateOf("")
    var isShowDialog by mutableStateOf(false)

    //  distinctUntilChanged : Flow 내용에 변화가 없으면 변수를 갱신하지 않음
    val tasks = taskDao.loadAllTasks().distinctUntilChanged()

    fun createTask() {
        // 코루틴 스코프
        viewModelScope.launch {
            val input = Task(title = title, description = description)
            taskDao.insertTask(input)
            Log.d(MainViewModel::class.simpleName, "created task")
        }
    }
}