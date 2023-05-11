package com.abdulaziz.trivia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun debugLog(message: String)