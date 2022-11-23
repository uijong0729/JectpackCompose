package com.example.todo.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.todo.ui.viewmodel.MainViewModel

@Composable
fun EditDialog(
    viewModel: MainViewModel = hiltViewModel(), // 인수로는 dagger에 의해 자동으로 넘어 옴
) {
    // 대문자로 시작하지만 함수임
    // 컴포넌트 단위는 대문자로 명명
    AlertDialog(
        onDismissRequest = {
            // 다이얼로그가 dismiss 되었을 경우
            viewModel.isShowDialog = false
        },
        title = { Text(text = "할 일 추가")},
        text = {
               Column {
                   Text(text = "제목")
                   TextField(value = viewModel.title, onValueChange = {
                       // it : 매개변수가 1개인 람다 함수는 it 키워드로 매개변수 이용
                       viewModel.title = it
                   })
                   Text(text = "할 일 상세")
                   TextField(value = viewModel.description, onValueChange = {
                       // it : 매개변수가 1개인 람다 함수는 it 키워드로 매개변수 이용
                       viewModel.description = it
                   })
               }
        },
        buttons = {
            Row(
                modifier = Modifier.padding(8.dp), 
                horizontalArrangement = Arrangement.Center
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {
                        // 다이얼로그가 취소되었을 경우
                        viewModel.isShowDialog = false
                    }
                ) {
                    Text(text = "취소")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {
                        viewModel.isShowDialog = false
                        viewModel.createTask()
                    }
                ) {
                    Text(text = "추가")
                }
            }
        }
    )
}
