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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.todo.ui.components.EditDialog
import com.example.todo.ui.theme.TodoTheme
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
                    mainContent(this@MainActivity)
                }
            }
        }
    }
}

@Composable
fun mainContent(context: Context) {
    // Main화면을 Resume해도 해당 변수는 초기화 되지 않도록 보관
    val isShowDialog = remember { mutableStateOf(false) }
    if (isShowDialog.value) {
        EditDialog(isShowDialog)
    }

    // 플로팅 액션버튼을 쓰기위한
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = {
            //Toast.makeText(context, "onClick", Toast.LENGTH_LONG).show()
            isShowDialog.value = true
        }) {
            // UI
            Icon(imageVector = Icons.Default.Add, contentDescription = "신규작성")
        }
    }) {

    }
}