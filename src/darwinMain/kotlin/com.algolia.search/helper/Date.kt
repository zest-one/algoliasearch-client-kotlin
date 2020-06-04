package com.algolia.search.helper

import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSLocale
import platform.Foundation.NSTimeZone
import platform.Foundation.create

internal actual object DateISO8601 {

    internal val dateISO8601 = DateFormatter(
        dateFormat = "yyyy-MM-dd'T'HH:mm:ss'Z'",
        locale = "en_US",
        timezone = "UTC"
    )

    internal val dateISO8601Millis = DateFormatter(
        dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",
        locale = "en_US",
        timezone = "UTC"
    )

    actual fun format(timestamp: Long, inMilliseconds: Boolean): String {
        val date = NSDate(timeIntervalSinceReferenceDate = timestamp.toDouble())
        return if (inMilliseconds) dateISO8601Millis.stringFromDate(date) else dateISO8601.stringFromDate(date)
    }

    actual fun parse(date: String, inMilliseconds: Boolean): Long {
        val value = if (inMilliseconds) {
            dateISO8601Millis.parse(date)?.timeIntervalSinceReferenceDate ?: -1
        } else {
            dateISO8601.parse(date)?.timeIntervalSinceReferenceDate ?: -1
        }
        return value as Long
    }
}

internal class DateFormatter(dateFormat: String, locale: String? = null, timezone: String? = null) {

    private val formatter = NSDateFormatter()

    init {
        formatter.dateFormat = dateFormat
        locale?.let { formatter.locale = NSLocale(localeIdentifier = it) }
        timezone?.let { formatter.timeZone = NSTimeZone.create(name = it)!! }
    }

    fun stringFromLong(timestamp: Long): String {
        val date = NSDate(timeIntervalSinceReferenceDate = timestamp.toDouble())
        return stringFromDate(date)
    }

    fun stringFromDate(date: NSDate): String {
        return formatter.stringFromDate(date)
    }

    fun parse(date: String): NSDate? {
        return formatter.dateFromString(date)
    }
}
