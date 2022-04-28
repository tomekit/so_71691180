package com.example.testapp

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class ContentObserverWorker(private val context: Context, private val params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        JobHelper.scheduleContentObserverWorker(context)

        Log.i("ContentURI", "doWork()")

        var result : Result = Result.success()

        try {
            if (params.triggeredContentUris.size > 0) {

                params.triggeredContentUris.forEach() {
                    Log.i("ContentURI", it.toString())
                }
            }
        } catch (e : Throwable) {
            Log.e("ContentURI", "Exception: $e")
            result = Result.retry()
        }

        return result
    }
}
