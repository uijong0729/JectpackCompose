package com.example.jetpackcompose

import android.icu.text.AlphabeticIndex.Bucket.LabelType
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
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

                        Spacer(modifier = Modifier.height(15.dp))

                        // 버튼표시
                        Button(
                            onClick = {
                                Toast
                                    .makeText(this@MainActivity, "button", Toast.LENGTH_LONG)
                                    .show()
                            },
                            Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A))
                        ) {
                            Text(text = "Show more", color = Color.White)
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        // 취미/거주지 표시
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(10.dp))
                                .background(Color.LightGray.copy(alpha = 0.3f)) // 투명도 30% 밝은 회색 배경
                                .padding(horizontal = 10.dp, vertical = 20.dp)
                        ) {
                            Label(
                                icon = Icons.Default.Favorite,
                                text = "Programming",
                                textColor = Color.Gray
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Label(
                                icon = Icons.Default.LocationOn,
                                text = "Tokyo",
                                textColor = Color.Gray
                            )
                        }

                    }

                }
            }
        }
    }
}

@Composable
fun Label(
    icon: ImageVector,
    text: String,
    textColor: Color = MaterialTheme.colors.onBackground // 아무것도 지정안하면 기본 테마색을 적용
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(icon, contentDescription = null)
        Spacer(modifier = Modifier.width(10.dp))
        Text(text = text, color = textColor, fontSize = 14.sp, fontWeight = FontWeight.Bold)
    }
}