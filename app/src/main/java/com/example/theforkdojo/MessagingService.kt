package com.example.theforkdojo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MessagingService : FirebaseMessagingService() {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://androidcodingdojo.appspot.com/")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()

    private val service = retrofit.create(TokenService::class.java)

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        val build = NotificationCompat.Builder(this, "123")
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(message.notification?.title)
            .setContentText(message.notification?.body)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationManager.createNotificationChannel(
                NotificationChannel(
                    "123",
                    "default",
                    NotificationManager.IMPORTANCE_DEFAULT
                )
            )
        }
        notificationManager.notify(123,build)
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        service.postToken(Token(token)).enqueue(object : Callback<Result> {
            override fun onResponse(call: Call<Result>, response: Response<Result>) {
                println(response.body())
            }

            override fun onFailure(call: Call<Result>, t: Throwable) {
                println(t)
            }
        })
    }

}
