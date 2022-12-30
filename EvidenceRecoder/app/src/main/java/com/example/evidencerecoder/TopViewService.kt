package com.example.evidencerecoder

import android.accessibilityservice.AccessibilityService
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.IBinder
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

class TopViewService : AccessibilityService() {
//    lateinit var iv :ImageView
    lateinit var iv :View

    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        TODO("Not yet implemented")
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        iv = View(baseContext).apply {
            setBackgroundColor(Color.RED)
            layoutParams = LinearLayout.LayoutParams(300, 300)
        }

//        iv = ImageView(baseContext).apply {
//            alpha = 0.8f
//            scaleType = ImageView.ScaleType.FIT_XY
//            scaleX = 40f
//            scaleY = 40f
//            setImageResource(R.drawable.ic_launcher_background)
//        }


        val param = WindowManager.LayoutParams(
            150,
            150,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.LEFT or Gravity.TOP
            verticalMargin = 0.1f
            horizontalMargin = 0.1f
        }

        val windowManager = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        windowManager.addView(iv, param)

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.removeView(iv);
    }
}