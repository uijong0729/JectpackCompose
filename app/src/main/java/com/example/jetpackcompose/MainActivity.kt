package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    // Compose Layout 참고
                    // https://developer.android.com/jetpack/compose/layout
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        // 텍스트를 표시하는 Compose
                        Text(
                            text = "User Name",
                            color = Color.Gray,
                            fontSize = 16.sp,                   // 코틀린 확장 함수 (기존에 정의된 클래스에 함수를 추가하는 기능)
                            fontWeight = FontWeight.ExtraBold,  // 글자 굵게
                        )

                        // 요소간의 간격을 두는 Compose
                        Spacer(
                            // Modifier 참고 (UI 컴포넌트에 부가효과를 추가)
                            // https://developer.android.com/jetpack/compose/modifiers
                            modifier = Modifier.height(20.dp)
                        )

                        Text(text = "Job", color = Color.Gray, fontSize = 16.sp)
                    }

                }
            }
        }
    }
}