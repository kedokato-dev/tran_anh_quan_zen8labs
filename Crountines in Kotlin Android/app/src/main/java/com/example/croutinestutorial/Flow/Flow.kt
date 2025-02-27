package com.example.croutinestutorial.Flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

//fun main() = runBlocking {
//    simpleFlow().collect { value ->
//        println(value)
//    }
//}

//fun main() = runBlocking {
//    simpleFlow()
//        .map { it * it }
//        .filter { it % 2 != 0 }
//        .collect { value ->
//            println(value)
//        }
//}

//fun main() = runBlocking {
//    simpleFlow()
//        .catch { e -> println("Caught exception: $e") }
//        .collect { value ->
//            println(value)
//        }
//}

fun main() = runBlocking {
    val flow1 = flowOf(1, 2, 3)
    val flow2 = flowOf("A", "B", "C")

    flow1.zip(flow2) { i, s -> "$i -> $s" }
        .collect { value ->
            println(value)
        }
}

fun simpleFlow(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}