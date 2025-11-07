package com.demox.core.data.ext

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


fun Long.toShortDataString():String{
    val date = Date(this * 1000)
    val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())

    return sdf.format(date)
}

fun Long.toLongDataString():String{
    val date = Date(this * 1000)
    val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())

    return sdf.format(date)
}

fun Long.toTimeString():String{
    val date = Date(this * 1000)
    val sdf = SimpleDateFormat("HH:mm", Locale.getDefault())

    return sdf.format(date)
}