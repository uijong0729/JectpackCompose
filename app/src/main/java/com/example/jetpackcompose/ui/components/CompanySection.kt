package com.example.jetpackcompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CompanySection(){
    Column(
        horizontalAlignment = Alignment.Start,    // 왼쪽 정렬
        modifier = Modifier.fillMaxWidth()        // 컬럼 100% 채우기
    ) {
        // 회사명
        Text(text = "CAP", fontSize = 26.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(9.dp))

        // 부서 그룹명
        Text(text = "System Solution", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(12.dp))
        // 이메일 표시
        // 가로로 요소 나열은 Row를 사용
        Label(icon = Icons.Default.Email, text = "Email")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "EmailSample@mail.co.kr", fontSize = 16.sp)
        Spacer(modifier = Modifier.height(5.dp))

        // 둥글둥글한 구분선
        Divider(
            thickness = 2.dp,
            modifier = Modifier.clip(RoundedCornerShape(1000.dp))
        )
    }
}