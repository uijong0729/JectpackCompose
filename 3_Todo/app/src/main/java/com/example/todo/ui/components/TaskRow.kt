package com.example.todo.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todo.Task

@Composable
fun TaskRow(
    task: Task,
    onClickRow: (Task) -> Unit,     // 콜백 인수 (Unit타입은 void에 상응)
    onClickDelete: (Task) -> Unit   // 콜백 인수 (Unit타입은 void에 상응)
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        elevation = 5.dp    // 떠있는 느낌을 줌
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .clickable { onClickRow(task) }, // 지정시 터치하면 반응함
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(text = task.title)
            Spacer(modifier = Modifier.weight(1f))
            IconButton(onClick = {
                onClickDelete(task)
            }) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "삭제"
                )
            }

        }
    }
}

@Preview    //왼쪽에 아이콘 누르면 프리뷰 볼 수 있음
@Composable
fun TaskRowPreview() {
    TaskRow(
        task = Task(title = "preview", description = ""),
        onClickDelete = {},
        onClickRow = {}
    )
}