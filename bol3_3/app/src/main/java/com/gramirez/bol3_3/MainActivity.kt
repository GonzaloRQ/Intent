package com.gramirez.bol3_3

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonAlarma = findViewById<Button>(R.id.alarm)
        val botonWebSearch = findViewById<Button>(R.id.webSearch)
        val botonGoToWeb = findViewById<Button>(R.id.goToWeb)

        botonAlarma.setOnClickListener {
            openAlarm(10, 30)
        }

        botonWebSearch.setOnClickListener {
            openWebSearch("https://www.youtube.com/watch?v=nUHKOgHgQc4&ab_channel=FarazHorserider")
        }

        botonGoToWeb.setOnClickListener {
            openWebPage("content://contacts/people/")
        }


    }

    private fun openWebPage(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun openWebSearch(query: String) {
        val intent = Intent(Intent.ACTION_WEB_SEARCH)
        intent.putExtra(SearchManager.QUERY, query)
        startActivity(intent)
    }

    private fun openAlarm(hour: Int, minutes: Int) {
        val intentAlarm = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_HOUR, 10)
            putExtra(AlarmClock.EXTRA_MINUTES, 30)
        }
        startActivity(intentAlarm)
    }


}

