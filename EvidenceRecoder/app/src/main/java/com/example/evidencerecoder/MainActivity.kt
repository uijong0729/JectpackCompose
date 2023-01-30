package com.example.evidencerecoder

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evidencerecoder.ui.theme.EvidenceRecoderTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var logic: TopViewLogic

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

    @Composable
    fun mainContent() {
        // https://developer.android.com/jetpack/compose/layouts/material#scaffold
        Scaffold(
            floatingActionButton = {
                FloatingActionButton(onClick = {

                }) {
                    // UI
                    Icon(imageVector = Icons.Default.Add, contentDescription = "버튼")
                }
            },
            topBar = {
                MainAppBar()
            },
        ) {
            Row() {
                Spacer(modifier = Modifier.width(10.dp))
                Row(verticalAlignment = Alignment.Top) {
                    Button(
                        onClick = { logic.callService(this@MainActivity) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A))
                    ) {
                        Text(
                            text = "시작",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Button(
                        onClick = { logic.killService(this@MainActivity) },
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFF85F6A))
                    ) {
                        Text(
                            text = " 종료",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun MainAppBar() {
        TopAppBar(
            title = { Text("Simple TopAppBar") },
            navigationIcon = {
                IconButton(onClick = { /* doSomething() */ }) {
                    Icon(Icons.Filled.Menu, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {
                    val intent = Intent(this@MainActivity, SettingActivity::class.java)
                    startActivity(intent)
                }) {
                    Icon(
                        Icons.Filled.Settings,
                        contentDescription = "Localized description"
                    )
                }
            }
        )
    }
}
