package com.example.jetpackcompose

import android.content.Context
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.components.CompanySection
import com.example.jetpackcompose.ui.components.DetailSection
import com.example.jetpackcompose.ui.components.Label
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
                    MainContent(this@MainActivity)
                }
            }
        }
    }
}

// Main UI
@Composable
fun MainContent(context: Context) {
    // Compose Layout 참고
    // https://developer.android.com/jetpack/compose/layout
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .verticalScroll(rememberScrollState())  // 스크롤 바 표시
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
        CompanySection()
        Spacer(modifier = Modifier.height(15.dp))

        // 버튼표시
        // val : immutable, var : mutable
        // mutableState : 값이 변하면 화면에 반영
        var isShowDetail by remember {      // remember 화면이 다시 표시되더라도 변수를 초기화하지 않음
            mutableStateOf(false)      // 초기화
        }
        Button(
            onClick = {
                Toast
                    .makeText(context, "button", Toast.LENGTH_LONG)
                    .show()
                isShowDetail = !isShowDetail
            },
            Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A))
        ) {
            Text(text = "Show more", color = Color.White)
        }

        // 취미/거주지 표시
        Spacer(modifier = Modifier.height(20.dp))
        if (isShowDetail) {
            DetailSection()
        }
    }
}