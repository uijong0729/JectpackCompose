package com.example.bmicalculator

import android.os.Bundle
import android.widget.NumberPicker.OnValueChangeListener
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmicalculator.ui.theme.BMICalculatorTheme

class MainActivity : ComponentActivity() {
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
                            value = "",
                            onValueChange = {},
                            label = "신장(cm)",
                            placeHolder = "178.5")

                        Spacer(modifier = Modifier.height(20.dp))

                        // 입력란 : 체중
                        PinkLabelTextField(
                            value = "",
                            onValueChange = {},
                            label = "체중(kg)",
                            placeHolder = "74.5")
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