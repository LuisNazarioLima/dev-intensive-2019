package ru.skillbranch.devintensive.extensions

import java.lang.IllegalStateException
import java.text.SimpleDateFormat
import java.util.*

const val SECOND = 1000L
const val MINUTE = 60* SECOND
const val HOUR = 60* MINUTE
const val DAY = 24* HOUR

fun Date.format(pattern:String="HH:mm:ss dd.MM.yy"):String {
    val dateFormat = SimpleDateFormat(pattern, Locale("ru"))
    return dateFormat.format(this)
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
            in 75 * SECOND..2 * MINUTE -> "две минуты назад"
            in 2 * MINUTE..4 * MINUTE -> "${time / MINUTE} минуты назад"
            in 4 * MINUTE..45 * MINUTE -> "${time / MINUTE} минут назад"
            //in 75* SECOND..45* MINUTE -> "N минут назад"
            in 45 * MINUTE..75 * MINUTE -> "час назад"
            in 75 * MINUTE..2 * HOUR -> "два часа назад"
            in 2 * HOUR..4 * HOUR -> "${time / HOUR} часа назад"
            in 4 * HOUR..22 * HOUR -> "${time / HOUR} часов назад"
            //in 75* MINUTE..22* HOUR -> "N часов назад"
            in 22 * HOUR..26 * HOUR -> "день назад"
            in 26 * HOUR..2 * DAY -> "два дня назад"
            in 2 * DAY..4 * DAY -> "${time / DAY} дня назад"
            in 4 * DAY..360 * DAY -> "${time / DAY} дней назад"
            //in 26* HOUR..360* DAY -> "N дней назад"
            else -> "более года назад"
        }
    } else {
        time = -1*time
        return when (time) {
            in 0..1 * SECOND -> "только что"
            in 1 * SECOND..45 * SECOND -> "через несколько секунд"
            in 45 * SECOND..75 * SECOND -> "через минуту"
            in 75 * SECOND..2 * MINUTE -> "через две минуты"
            in 2 * MINUTE..4 * MINUTE -> "через ${time / MINUTE +1} минуты"
            in 4 * MINUTE..45 * MINUTE -> "через ${time / MINUTE+1} минут"
            //in 75* SECOND..45* MINUTE -> "N минут назад"
            in 45 * MINUTE..75 * MINUTE -> "через час"
            in 75 * MINUTE..2 * HOUR -> "через два часа"
            in 2 * HOUR..4 * HOUR -> "через ${time / HOUR+1} часа"
            in 4 * HOUR..22 * HOUR -> "через ${time / HOUR+1} часов"
            //in 75* MINUTE..22* HOUR -> "N часов назад"
            in 22 * HOUR..26 * HOUR -> "через день"
            in 26 * HOUR..2 * DAY -> "через два дня"
            in 2 * DAY..4 * DAY -> "через ${time / DAY+1} дня"
            in 4 * DAY..360 * DAY -> "через ${time / DAY+1} дней"
            //in 26* HOUR..360* DAY -> "N дней назад"
            else -> "больше чем через год"
        }
    }
}
enum class TimeUnits{
    SECOND,
    MINUTE,
    HOUR,
    DAY
}