package com.example.evidencerecoder

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evidencerecoder.ui.theme.EvidenceRecoderTheme

class SettingActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EvidenceRecoderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    mainContent()
                }
            }
        }
    }

    @Preview
    @Composable
    fun mainContent() {
        Column() {
            Row() {
                Text(text = "Switch")
                Switch(checked = false, onCheckedChange = {
                    Toast.makeText(this@SettingActivity, "test : $it", Toast.LENGTH_LONG).show()
                })
            }

            Spacer(
                modifier = Modifier
                    .width(10.dp)
                    .height(10.dp)
            )

            Row() {
                Text(text = "Switch2")
                Switch(checked = false, onCheckedChange = {
                    Toast.makeText(this@SettingActivity, "test : $it", Toast.LENGTH_LONG).show()
                })
            }

            alertDialog()
        }
    }

    // ref: https://semicolonspace.com/jetpack-compose-dialog/
    @Composable
    fun alertDialog() {
        AlertDialog(
            onDismissRequest = { /*TODO*/ },
            buttons = {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(onClick = {

                    }) {
                        Text(text = "Confirm")
                    }
                    Button(onClick = {

                    }) {
                        Text(text = "Dismiss")
                    }
                }
            },
            title = {
                Text(text = "Title")
            },
            text = {
                Text(text = "Description")
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(32.dp)
        )
    }
}