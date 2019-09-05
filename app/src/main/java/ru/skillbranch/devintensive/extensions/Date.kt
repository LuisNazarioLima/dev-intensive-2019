package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.exp
import kotlin.math.pow

const val SECOND = 1000L
const val MINUTE = 60* SECOND
const val HOUR = 60* MINUTE
const val DAY = 24* HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.shortFofmat(): String {
    val pattern = if(this.isSameDay(Date())) "HH:mm" else "dd.MM.mm"
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
}
fun Date.isSameDay(date: Date): Boolean {
    val day1 = this.time/ DAY
    val day2 = date.time/ DAY
    return day1 == day2
}

fun Date.add(value:Int, units: TimeUnits = TimeUnits.SECOND): Date {
    var time = this.time
    time += when (units) {
        TimeUnits.SECOND -> value * SECOND
        TimeUnits.MINUTE -> value * MINUTE
        TimeUnits.HOUR -> value * HOUR
        TimeUnits.DAY -> value * DAY
    }
    this.time = time
    return this
}
fun Date.humanizeDiff(date: Date = Date()) : String {
    var time = this.time
    time = date.time - time
    if (time >= 0) {
        return when (time) {
            in 0..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "несколько секунд назад"
            in 45 * SECOND..75 * SECOND -> "минуту назад"
            in 75 * SECOND..2 * MINUTE -> "2 минуты назад"
            in 2 * MINUTE..5 * MINUTE -> "${time / MINUTE} минуты назад"
            in 5 * MINUTE..46 * MINUTE -> "${time / MINUTE} минут назад"
            //in 75* SECOND..45* MINUTE -> "N минут назад"
            in 46 * MINUTE..76 * MINUTE -> "час назад"
            in 76 * MINUTE..2 * HOUR -> "2 часа назад"
            in 2 * HOUR..4 * HOUR -> "${time / HOUR} часа назад"
            in 5 * HOUR..21 * HOUR -> "${time / HOUR} часов назад"
            in 21 * HOUR..22 * HOUR -> "${time / HOUR} час назад"
            in 22 * HOUR..27 * HOUR -> "день назад"
            //in 75* MINUTE..22* HOUR -> "N часов назад"
            in 27 * HOUR..2 * DAY -> "2 дня назад"
            in 2 * DAY..5 * DAY -> "${time / DAY} дня назад"
            in 5 * DAY..361 * DAY -> "${time / DAY} дней назад"
            //in 26* HOUR..360* DAY -> "N дней назад"
            else -> "более года назад"
        }
    } else {
        time = -1*time
        return when (time) {
            in 0..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "через несколько секунд"
            in 45 * SECOND..75 * SECOND -> "через минуту"
            in 75 * SECOND..2 * MINUTE -> "через 2 минуты"
            in 2 * MINUTE..4 * MINUTE -> "через ${time / MINUTE} минуты"
            in 4 * MINUTE..45 * MINUTE -> "через ${time / MINUTE} минут"
            //in 75* SECOND..45* MINUTE -> "N минут назад"
            in 45 * MINUTE..75 * MINUTE -> "через час"
            in 75 * MINUTE..2 * HOUR -> "через 2 часа"
            in 2 * HOUR..4 * HOUR -> "через ${time / HOUR} часа"
            in 4 * HOUR..21 * HOUR -> "через ${time / HOUR} часов"
            in 21 * HOUR..22 * HOUR -> "через ${time / HOUR} часа"
            //in 75* MINUTE..22* HOUR -> "N часов назад"
            in 22 * HOUR..26 * HOUR -> "через день"
            in 26 * HOUR..2 * DAY -> "через 2 дня"
            in 2 * DAY..4 * DAY -> "через ${time / DAY} дня"
            in 4 * DAY..360 * DAY -> "через ${time / DAY} дней"
            //in 26* HOUR..360* DAY -> "N дней назад"
            else -> "больше чем через год"
        }
    }
}
enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY;

fun plural(i: Int = 0): String? {
    var ost: Float
    var powerFloat: Float = 10F
    var lastChar: String

    if (this == null) {
        return null
    }

    ost = i.toString().substring(i.toString().length-1, i.toString().length).toFloat()

 /*   if (i >= 0) {
        if (i > 10) {
            ost = i - powerFloat.pow(i.toString().length - 1)
        } else {ost = i.toFloat()}
    } else {
        if (i < -10) {
            ost = powerFloat.pow(i.toString().length - 2) - i
        } else {ost = -i.toFloat()}
    } */
    return when {
        (i == 0) && this == TimeUnits.SECOND -> "$i секунд"
        (ost.toInt() == 1) && this == TimeUnits.SECOND -> "$i секунду"
        (ost.toInt() in 2..4) && this == TimeUnits.SECOND -> "$i секунды"
        (ost.toInt() in 5..100) && this == TimeUnits.SECOND -> "$i секунд"

        (i == 0) && this == TimeUnits.MINUTE -> "$i минут"
        (ost.toInt() == 1) && this == TimeUnits.MINUTE -> "$i минуту"
        (ost.toInt() in 2..4) && this == TimeUnits.MINUTE -> "$i минуты"
        (ost.toInt() in 5..100) && this == TimeUnits.MINUTE -> "$i минут"

        (i == 0) && this == TimeUnits.HOUR -> "$i часов"
        (ost.toInt() == 1) && this == TimeUnits.HOUR -> "$i час"
        (ost.toInt() in 2..4) && this == TimeUnits.HOUR -> "$i часа"
        (ost.toInt() in 5..100) && this == TimeUnits.HOUR -> "$i часов"

        (i == 0) && this == TimeUnits.DAY -> "$i дней"
        (ost.toInt() == 1) && this == TimeUnits.DAY -> "$i день"
        (ost.toInt() in 2..4) && this == TimeUnits.DAY -> "$i дня"
        (ost.toInt() in 5..100) && this == TimeUnits.DAY -> "$i дней"

        else -> ""
    }
}
}