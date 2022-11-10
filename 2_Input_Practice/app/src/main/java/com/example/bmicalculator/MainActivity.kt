package com.example.bmicalculator

import android.os.Bundle
import android.util.Log
import android.widget.NumberPicker.OnValueChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
    // by 키워드를 사용하게 되면, 컴파일러가 자동으로 Delegate Pattern 코드를 작성
    // by 키워드로 인해 viewModels<> 인터페이스의 각 함수들을 구현하지 않아도 사용할 수 있다.
    private val viewModel by viewModels<MainViewModel>();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BMICalculatorTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier.padding(20.dp)
                    ) {
                        // 타이틀
                        Text(
                            text = "BMI계산 어플리케이션",
                            fontSize = 26.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                        Spacer(modifier = Modifier.height(30.dp))

                        // 입력란 : 키
                        PinkLabelTextField(
                            value = viewModel.height,
                            onValueChange = {
                                // it : 유저가 입력한 값
                                // 인수로 들어오는 변수가 한개인 경우 [it]으로 받을 수 있다.
                                viewModel.height = it
                            },
                            label = "신장(cm)",
                            placeHolder = "178.5")

                        Spacer(modifier = Modifier.height(20.dp))

                        // 입력란 : 체중
                        PinkLabelTextField(
                            value = viewModel.weight,
                            onValueChange = {
                                viewModel.weight = it
                            },
                            label = "체중(kg)",
                            placeHolder = "74.5")

                        Spacer(modifier = Modifier.height(30.dp))

                        // 계산 버튼
                        Button(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = Color(0xFFF85F6A)
                            )
                        ) {
                            Text(text = "계산하기", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        // 계산 결과 표시
                        Text(text = "당신의 BMI는 0.00입니다.",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun PinkLabelTextField(
    value: String,
    onValueChange: ((String) -> Unit),
    label: String,
    placeHolder: String,
) {
    Column {
        Text(
            text = label,
            color = Color(0xFFF85F6A),
            fontWeight = FontWeight.Bold,
        )
        // value : 값
        // onValueChange : 콜백
        TextField(
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = placeHolder) },
            value = value,
            onValueChange = onValueChange,
            colors = TextFieldDefaults.textFieldColors(backgroundColor = Color.Transparent), // 입력란 투명
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),          // 키보드 숫자
            singleLine = true,                                                              // 한 줄 입력란
        )
    }
}