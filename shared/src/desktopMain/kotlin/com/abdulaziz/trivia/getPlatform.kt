package com.abdulaziz.trivia

actual fun getPlatform(): Platform{
    return object : Platform {
        override val name: String = "JVM"
    }
}

actual fun debugLog(message: String){
    println(message)
}