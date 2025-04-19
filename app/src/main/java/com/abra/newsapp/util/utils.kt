package com.abra.newsapp.util

fun String.formatNewsTime(): String {
    val date = this.slice(0..9)
    val time = this.slice(11..15)
    return try {
        "$date $time"
    } catch (e: Exception) {
        this
    }
}

