package com.example.todo.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.todo.Task

@Composable
fun TaskList(
    tasks: List<Task>,
    onClickRow: (Task) -> Unit,
    onClickDelete: (Task) -> Unit,
) {
    // Column은 한방에 쫙 초기화되기 떄문에 리스트 변동이 심하면 퍼포먼스에 악영향을 준다
    // 그래서 사용하는게 LazyColumn
    // https://developer.android.com/jetpack/compose/lists#lazylistscope
    // 참고 : DSL (상용구 코드를 최소화하는 언어 Domain Specific Language)
    LazyColumn {
        items(tasks) { item: Task ->
            TaskRow(
                task = item,
                onClickRow = onClickRow,
                onClickDelete = onClickDelete
            )
        }
    }
}