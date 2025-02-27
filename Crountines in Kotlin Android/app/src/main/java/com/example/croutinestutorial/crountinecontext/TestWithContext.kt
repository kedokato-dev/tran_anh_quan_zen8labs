package com.example.croutinestutorial.crountinecontext

import android.util.Log
import com.example.croutinestutorial.MainActivity
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

object TestWithContext {
    fun TestWithContextFunc() {
        newSingleThreadContext("Thread 1").use { context1 ->
            Log.d(
                MainActivity::class.java.simpleName,
                "Context 1 - Thread : ${Thread.currentThread().name}"
            )
            newSingleThreadContext("Thread 2").use { context2 ->
                Log.d(
                    MainActivity::class.java.simpleName,
                    "Context 2 - Thread : ${Thread.currentThread().name}"
                )
                runBlocking(context1) {
                    Log.d(
                        MainActivity::class.java.simpleName,
                        "Working in Context 1 - Thread: ${Thread.currentThread().name}"
                    )
                    withContext(context2) {
                        Log.d(
                            MainActivity::class.java.simpleName,
                            "Working Context 2 - Thread: ${Thread.currentThread().name}"
                        )
                    }
                    Log.d(
                        MainActivity::class.java.simpleName,
                        "BackContext 1 - Thread: ${Thread.currentThread().name}"
                    )
                }
            }
        }
    }
}