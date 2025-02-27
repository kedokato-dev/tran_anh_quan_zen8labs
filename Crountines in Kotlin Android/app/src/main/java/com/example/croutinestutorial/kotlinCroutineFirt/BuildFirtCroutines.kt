package com.example.croutinestutorial.kotlinCroutineFirt

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.concurrent.thread

//fun main() {
//    GlobalScope.launch {
//        delay(1000)
//        println("xin chao")
//    }
//    println("ban")
//    thread {
//        Thread.sleep(2000L)
//    }
//}

//fun main() {
//    runBlocking {
//        delay(1000)
//        println("hello")
//        delay(1000)
//        println("Kotlin")
//    }
//}


fun main() {
    val start = System.currentTimeMillis()
    runBlocking {
        repeat(1_000_000){
            launch {
                println("hello coroutines !")
            }
        }
    }
    val end = System.currentTimeMillis()
    println("Time: = ${end - start} ms")
}
