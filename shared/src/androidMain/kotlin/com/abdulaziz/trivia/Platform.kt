package com.abdulaziz.trivia

import android.util.Log

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual fun debugLog(message: String) {
    Log.d("Trivia-Compose", message)
}