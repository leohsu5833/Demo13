package com.example.demo13

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener(this)
        findViewById<Button>(R.id.button2).setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val intent = Intent()
        intent.setClass(this, EchoService::class.java)
        when (p0!!.id) {
            R.id.button1 -> startService(intent)
            R.id.button2 -> stopService(intent)
        }
    }
}