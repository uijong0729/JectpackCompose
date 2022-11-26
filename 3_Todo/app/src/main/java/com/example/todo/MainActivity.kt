package com.example.todo

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.ui.components.EditDialog
import com.example.todo.ui.components.TaskList
import com.example.todo.ui.theme.TodoTheme
import com.example.todo.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// 이 메인액티비티가 엔트리 포인트입니다
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainContent()
                }
            }
        }
    }
}

@Composable
fun mainContent(viewModel: MainViewModel = hiltViewModel()) {
    // Main화면을 Resume해도 해당 변수는 초기화 되지 않도록 보관
    // 액티비티 클래스에 이 변수를 선언해버리면, 화면을 회전시켰을때 변수가 초기화되므로 주의
    // val isShowDialog = remember { mutableStateOf(false) }
    if (viewModel.isShowDialog) {
        EditDialog()
    }

    // 플로팅 액션버튼을 쓰기위한
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            //Toast.makeText(context, "onClick", Toast.LENGTH_LONG).show()
            viewModel.isShowDialog = true
        }) {
            // UI
            Icon(imageVector = Icons.Default.Add, contentDescription = "신규작성")
        }
    }) {
        // Task정보
        val tasks by viewModel.tasks.collectAsState(initial = emptyList())
        Log.d("count tasks", tasks.size.toString())
        TaskList(
            tasks = tasks,
            onClickRow = {},
            onClickDelete = {}
        )
    }
}