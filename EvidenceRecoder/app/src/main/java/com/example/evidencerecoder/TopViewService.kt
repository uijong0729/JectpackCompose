package com.example.evidencerecoder

import android.accessibilityservice.AccessibilityService
import android.annotation.SuppressLint
import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.PixelFormat
import android.os.Build
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.view.accessibility.AccessibilityEvent
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi

class TopViewService : AccessibilityService() {
    //    lateinit var iv :ImageView
    lateinit var iv: View
    lateinit var params: WindowManager.LayoutParams
    lateinit var windowManager: WindowManager

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

        windowManager = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val height = (resources.displayMetrics.heightPixels * 0.1).toInt()
        val width = (resources.displayMetrics.widthPixels * 0.2).toInt()
        params = WindowManager.LayoutParams(
            width,
            height,
            WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY,
            WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH
                    or WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                    or WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                    or WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
            PixelFormat.TRANSLUCENT
        ).apply {
            gravity = Gravity.START or Gravity.TOP
            verticalMargin = 0.1f
            horizontalMargin = 0.1f
        }
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)

        iv = View(this@TopViewService).apply {
            this.setBackgroundColor(Color.RED)
            this.setOnTouchListener { view, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        view.performClick()
                        Toast.makeText(baseContext, "Test", Toast.LENGTH_LONG).show()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }

        windowManager.addView(iv, params)

        return Service.START_STICKY
    }

    override fun stopService(name: Intent?): Boolean {
        val windowManager = getSystemService(WINDOW_SERVICE) as WindowManager
        windowManager.removeView(iv);
        return super.stopService(name)
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