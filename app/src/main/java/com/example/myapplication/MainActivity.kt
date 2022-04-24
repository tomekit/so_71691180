package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.testapp.JobHelper

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        JobHelper.scheduleContentObserverWorker(applicationContext)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}