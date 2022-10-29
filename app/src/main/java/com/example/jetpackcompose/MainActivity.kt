package com.example.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
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
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        // 사진
                        Image(
                            painter = painterResource(id = R.drawable.capture),     // 사진 리소스
                            contentDescription = "프로필 사진",                        // 사진이 보이지 않는 사람들을 위한 텍스트
                            modifier = Modifier
                                .size(100.dp)                       // 이미지 크기 조절
                                .clip(RoundedCornerShape(10.dp))    // 이미지 모서리 둥글게
                        )
                        Spacer(modifier = Modifier.height(15.dp))
                        
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
                            modifier = Modifier.height(15.dp)
                        )

                        // 직업표시 Compose
                        Text(text = "Engineer", color = Color.Gray, fontSize = 16.sp)

                        // 회사 정보
                        Spacer(modifier = Modifier.height(15.dp))
                        Column(
                            horizontalAlignment = Alignment.Start,    // 왼쪽 정렬
                            modifier = Modifier.fillMaxWidth()        // 컬럼 100% 채우기
                        ) {
                            // 회사명
                            Text(text = "CAP", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                            Spacer(modifier = Modifier.height(9.dp))

                            // 부서 그룹명
                            Text(text = "System Solution", fontSize = 16.sp, color = Color.Gray)
                        }
                    }

                }
            }
        }
    }
}