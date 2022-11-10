package com.example.bmicalculator

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

// ViewModel사용
// Activity 에서 데이터를 관리하면, 화면 회전 등의 조작에 데이터가 파기되어 버린다.
class MainViewModel : ViewModel() {
    // 키 height의 변화를 mutableStateOf가 감시 : 초기값 ""
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
}