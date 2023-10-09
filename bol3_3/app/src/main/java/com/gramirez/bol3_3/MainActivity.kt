package com.gramirez.bol3_3

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonAlarma = findViewById<Button>(R.id.alarm)
        val botonWebSearch = findViewById<Button>(R.id.webSearch)
        val botonGoToWeb = findViewById<Button>(R.id.goToWeb)

        botonAlarma.setOnClickListener {
            val intentAlarm = Intent(AlarmClock.ACTION_SET_ALARM).apply {
                putExtra(AlarmClock.EXTRA_HOUR, 10)
                putExtra(AlarmClock.EXTRA_MINUTES, 30)
            }
                startActivity(intentAlarm)
        }

        botonWebSearch.setOnClickListener {
            val intentWeb = Intent(Intent.ACTION_WEB_SEARCH).apply {
                putExtra(SearchManager.QUERY, "https://www.youtube.com/watch?v=nUHKOgHgQc4&ab_channel=FarazHorserider")
            }

                startActivity(intentWeb)

        }

        botonGoToWeb.setOnClickListener {
            val intentViewWeb = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse("content://contacts/people/")

            }

                startActivity(intentViewWeb)
        }
    }






}

