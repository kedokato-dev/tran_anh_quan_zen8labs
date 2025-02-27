package com.example.croutinestutorial.async_await

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() {
    runBlocking {
//        val time = measureTimeMillis {
////            val a = launch { doSomethingFunny1() }
////            val b =launch { doSomethingFunny2() }
////
////            println(a+b)
//        }
        val time = measureTimeMillis {
            val a:Deferred<Int> = async { doSomethingFunny1() }
            val b:Deferred<Int> = async { doSomethingFunny2() }
            println(a.await()+b.await())
        }
        println("time = $time")

    }
}

suspend fun doSomethingFunny1():Int{
    delay(1000)
    return 10
}


suspend fun doSomethingFunny2(): Int{
    delay(1000)
    return 20
}