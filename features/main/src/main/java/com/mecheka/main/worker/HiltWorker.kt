package com.mecheka.main.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.mecheka.main.RandomNumber
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class HiltWorker @AssistedInject constructor(
    private val randomNumber: RandomNumber,
    @Assisted context: Context,
    @Assisted params: WorkerParameters
): CoroutineWorker(context, params) {
    override suspend fun doWork(): Result {
        randomNumber.random()
        Log.d("HiltWorker", "doWork: HiltWorker")
        Log.d("HiltWorker", "Random number: ${randomNumber.number}")
        return Result.success()
    }
}