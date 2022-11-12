package com.example.bmicalculator

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

// ViewModel사용
// Activity 에서 데이터를 관리하면, 화면 회전 등의 조작에 데이터가 파기되어 버린다.
class MainViewModel : ViewModel() {
    // 키 height의 변화를 mutableStateOf가 감시 : 초기값 ""
    var height by mutableStateOf("")
    var weight by mutableStateOf("")
    var bmiResult by mutableStateOf(0f)

    // BMI계산식 : BMI = 체중 / 신장^2
    fun calcBmi() {
        // string to float
        // toFloatOrNull : float 변환 불가능하면 null을 반환
        // div(100)      : 100으로 나눔
        // ?:            : 좌항이 null이면 null을 반환
        // ?:0f          : 좌항이 null이면 0f를 반환
        val heightNumber = height.toFloatOrNull()?.div(100) ?: 0f
        val weightNumber = weight.toFloatOrNull() ?: 0f

        Log.d("키", heightNumber.toString())
        Log.d("몸무게", weightNumber.toString())

        // roundToInt : 반올림
        bmiResult = if (weightNumber > 0f && heightNumber > 0f) {
            ((weightNumber / heightNumber.pow(2)) * 10).roundToInt() / 10f
        } else 0f
    }
}