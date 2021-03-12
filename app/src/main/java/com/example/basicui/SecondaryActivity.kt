package com.example.basicui

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.basicui.databinding.ActivitySecondaryBinding
import splitties.toast.longToast

class SecondaryActivity : AppCompatActivity() {
    private lateinit var binding :  ActivitySecondaryBinding
    lateinit var notificationManager: NotificationManager
    private val channelId = "12345"
    private val description = "Test Notification"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondaryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as
                NotificationManager
        binding.sendNotificationButton.setOnClickListener(){
            btnNotify(it)
        }
    }
    fun btnNotify(view: View) {
        var builder : Notification.Builder? = null

        val intent = Intent(this, LauncherActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            var notificationChannel = NotificationChannel(channelId, description, NotificationManager .IMPORTANCE_HIGH)
            notificationChannel.lightColor = Color.BLUE
            notificationChannel.enableVibration(true)
            notificationManager.createNotificationChannel(notificationChannel)
            builder = Notification.Builder(this, channelId).setContentTitle("NOTIFICATION USING " +
                    "KOTLIN").setContentText("Test Notification").setSmallIcon(R.drawable.poussin_couteau_background).setLargeIcon(
                BitmapFactory.decodeResource(this.resources, R.drawable
                .poussin_couteau_background)).setContentIntent(pendingIntent)
                notificationManager.notify(12345, builder?.build())
        }
        else{
            longToast(R.string.old_device_message)
            Log.i(SecondaryActivity::class.simpleName,"T'es trop vieux, cheh.")
        }
    }
}