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

    // distinctUntilChanged : Flow 내용에 변화가 없으면 변수를 갱신하지 않음
    val tasks = taskDao.loadAllTasks().distinctUntilChanged()
    // 현재 편집 중인 Todo를 보존
    private var editingTask: Task? = null;
    // 현재 편집 중인가?
    val isEditing: Boolean
        // 코틀린은 get, set변수를 자동생성하기 때문에 필요없지만
        // get 코드 작성시 get으로 호출 될때 반환 될 return을 작성하면 커스텀 get을 만들 수 있다.
        get() = editingTask != null

    // 다이얼로그를 열면 편집 중인 것으로 파악
    fun setEditingTask(task: Task) {
        editingTask = task
        title = task.title
        description = task.description
    }

    fun createTask() {
        // 코루틴 스코프
        viewModelScope.launch {
            val input = Task(title = title, description = description)
            taskDao.insertTask(input)
            Log.d(MainViewModel::class.simpleName, "created task")
        }
    }

    fun deleteTask(task: Task) {
        viewModelScope.launch {
            taskDao.deleteTask(task)
        }
    }

    fun updateTask() {
        // editingTask가 null이 아니면 let블록을 실행
        editingTask?.let {
            viewModelScope.launch {
                it.title = title
                it.description = description
                taskDao.updateTask(it)
            }
        }
    }

    fun clear() {
        title = ""
        description = ""
        editingTask = null
    }
}