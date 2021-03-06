package com.foodiedev.setrepetitiveexactalarm.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.text.format.DateFormat

import com.foodiedev.setrepetitiveexactalarm.util.Constants
import io.karn.notify.Notify



class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val timeInMillis = intent.getLongExtra(Constants.EXTRA_EXACT_ALARM_TIME, 0L)
        when (intent.action) {
            Constants.ACTION_SET_EXACT -> {
                buildNotification(context, "Arailym's Notification", convertDate(timeInMillis))
            }

            Constants.ACTION_SET_REPETITIVE_EXACT -> {

            }
        }
    }

    private fun buildNotification(context: Context, title: String, message: String) {
        Notify
            .with(context)
            .content {
                this.title = title
                text = "It's time:  $message"
            }
            .show()
    }



    private fun convertDate(timeInMillis: Long): String =
        DateFormat.format("dd/MM/yyyy hh:mm:ss", timeInMillis).toString()

}