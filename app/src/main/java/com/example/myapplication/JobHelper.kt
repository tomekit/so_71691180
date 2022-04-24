package com.example.testapp

import android.content.Context
import android.provider.MediaStore
import androidx.work.*

object JobHelper {

    const val CONTENT_OBSERVER_WORK = "CONTENT_OBSERVER_WORK"

    fun scheduleContentObserverWorker(context: Context) {
        val constraints = Constraints.Builder()
            .addContentUriTrigger(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, true)
            .build()


        val request = OneTimeWorkRequest.Builder(ContentObserverWorker::class.java)
            .setConstraints(constraints)
            .build()

        WorkManager.getInstance(context).enqueueUniqueWork(CONTENT_OBSERVER_WORK, ExistingWorkPolicy.REPLACE, request)
    }
}