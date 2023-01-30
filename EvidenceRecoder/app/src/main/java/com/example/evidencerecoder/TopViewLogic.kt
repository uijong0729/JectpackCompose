package com.example.evidencerecoder

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startForegroundService

class TopViewLogic {

    fun callService(activity: MainActivity) {
        // 서비스
        // https://developer.android.com/guide/components/services?hl=ko
        Intent(activity, TopViewService::class.java).also { intent ->
            startForegroundService(activity, intent)
        }
    }

    fun killService(activity: MainActivity) {
        Intent(activity, TopViewService::class.java).also { intent ->
            activity.stopService(intent)
        }
    }
}