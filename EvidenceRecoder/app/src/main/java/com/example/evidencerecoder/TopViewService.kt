package com.example.evidencerecoder

import android.accessibilityservice.AccessibilityService
import android.app.*
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.Build
import android.os.IBinder
import android.view.Gravity
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.ui.platform.ComposeView
import androidx.lifecycle.ViewTreeLifecycleOwner

class TopViewService : AccessibilityService() {
    //    lateinit var iv :ImageView
    lateinit var iv: View

    override fun onAccessibilityEvent(p0: AccessibilityEvent?) {
        TODO("Not yet implemented")
    }

    override fun onInterrupt() {
        TODO("Not yet implemented")
    }

    override fun onCreate() {
        super.onCreate()

        val channelId = createNotificationChannel("my_service", "My Background Service")

        // 포그라운드 서비스 알림
        val pendingIntent: PendingIntent =
            Intent(this, MainActivity::class.java).let { notificationIntent ->
                PendingIntent.getActivity(this, 0, notificationIntent, 0)
            }

        val notification: Notification = Notification.Builder(this, channelId)
            .setContentTitle("getText(R.string.notification_title)")
            .setContentText("getText(R.string.notification_message)")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentIntent(pendingIntent)
            .setTicker("getText(R.string.ticker_text)")
            .build()

        startForeground(101, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        iv = View(baseContext).apply {
            setBackgroundColor(Color.RED)
            layoutParams = LinearLayout.LayoutParams(300, 300)
            this.setOnClickListener {
                Toast.makeText(baseContext, "Test", Toast.LENGTH_LONG).show()
            }
        }

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

        return Service.START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.removeView(iv);
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(channelId: String, channelName: String): String {
        val chan = NotificationChannel(
            channelId,
            channelName, NotificationManager.IMPORTANCE_NONE
        )
        chan.lightColor = Color.BLUE
        chan.lockscreenVisibility = Notification.VISIBILITY_PRIVATE
        val service = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        service.createNotificationChannel(chan)
        return channelId
    }
}