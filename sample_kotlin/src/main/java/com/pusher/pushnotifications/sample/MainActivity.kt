package com.pusher.pushnotifications.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.pusher.pushnotifications.PushNotifications
import com.pusher.pushnotifications.PushNotificationsInstance

class MainActivity : AppCompatActivity() {
  lateinit var pn: PushNotificationsInstance
  private val instanceId = "8a070eaa-033f-46d6-bb90-f4c15acc47e1"

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    PushNotifications.start(applicationContext, instanceId)

    PushNotifications.subscribe("hello")
    PushNotifications.subscribe("donuts")
    PushNotifications.subscribe("hello-donuts")

    Log.i("MainActivity", "Current subscriptions are:")
    PushNotifications.getSubscriptions().forEach { interest ->
      Log.i("MainActivity", "\t$interest")
    }
  }
}
