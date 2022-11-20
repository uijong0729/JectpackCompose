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

@Composable
fun EditDialog(isShowDialog :MutableState<Boolean>) {
    // 대문자로 시작하지만 함수임
    // 컴포넌트 단위는 대문자로 명명
    AlertDialog(
        onDismissRequest = {
            // 다이얼로그가 dismiss 되었을 경우
            isShowDialog.value = false
        },
        title = { Text(text = "할 일 추가")},
        text = {
               Column {
                   Text(text = "제목")
                   TextField(value = "", onValueChange = {})
                   Text(text = "할 일 상세")
                   TextField(value = "", onValueChange = {})
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
                        isShowDialog.value = false
                    }
                ) {
                    Text(text = "취소")
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(
                    modifier = Modifier.width(120.dp),
                    onClick = {
                        isShowDialog.value = false
                    }
                ) {
                    Text(text = "추가")
                }
            }
        }
    )
}
