package com.example.login

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class FiveTaskActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fivetask)

        findViewById<Button>(R.id.btnGotoWWW).setOnClickListener {openWebsite()}
        findViewById<Button>(R.id.btnGoogleMap).setOnClickListener {runGoogleMap()}
        findViewById<Button>(R.id.btnStartTimer).setOnClickListener {startTimer(
            "Good Morning," +
                    "Eat your Breakfast and have a Goodday",
            5
        )}
        findViewById<Button>(R.id.btnAnswer).setOnClickListener {answer()}
        findViewById<Button>(R.id.btnCallMe).setOnClickListener {callme()}
    }
    private fun openWebsite() {
        val intent1 = Intent(Intent.ACTION_WEB_SEARCH)
        val uriData = Uri.parse("https://www.google.com")
        startActivity(intent1)
    }
    private fun runGoogleMap(){
        val gmmIntentUri = Uri.parse("geo:16.409432, 120.604370")
        val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
        mapIntent.setPackage("com.google.android.apps.maps")
        if (mapIntent.resolveActivity(packageManager) != null) {
            startActivity(mapIntent)
        }
    }
    private fun startTimer(message: String, seconds: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_TIMER).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_LENGTH, seconds)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    private fun answer(){
//      Post an intent to reload
        val intent = Intent(Intent.ACTION_ANSWER)
        Toast.makeText(this,"PASENSYA KA NA, GODBLESS DI GUMAGANA",Toast.LENGTH_LONG).show()
        sendBroadcast(intent)
    }
    private fun callme(){
        val intent = Intent(Intent.ACTION_CALL)
        Toast.makeText(this,"PASENSYA KA NA, GODBLESS DI GUMAGANA",Toast.LENGTH_LONG).show()
        startActivity(intent)
    }

}