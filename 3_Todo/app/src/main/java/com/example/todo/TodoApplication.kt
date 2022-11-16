package com.example.todo

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

// Manifest 추가 필요
@HiltAndroidApp
class TodoApplication :Application() {

}