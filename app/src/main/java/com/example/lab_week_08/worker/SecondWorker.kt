package com.example.lab_week_08.worker

import android.content.Context
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class SecondWorker(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    companion object {
        const val INPUT_DATA_ID = "inId"
        const val OUTPUT_DATA_ID = "outId"
    }

    // Executes the background process and returns a result
    override fun doWork(): Result {
        // Get the input parameter
        val id = inputData.getString(INPUT_DATA_ID) ?: "Unknown"

        // Simulate a long-running task (3 seconds)
        Thread.sleep(3000L)

        // Prepare the output data
        val outputData = Data.Builder()
            .putString(OUTPUT_DATA_ID, "SecondWorker processed ID: $id")
            .build()

        // Return success result with output data
        return Result.success(outputData)
    }
}
