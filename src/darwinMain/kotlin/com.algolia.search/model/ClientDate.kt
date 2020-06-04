package com.algolia.search.model

import com.algolia.search.helper.DateISO8601
import com.algolia.search.serialize.KSerializerClientDate
import kotlinx.serialization.Serializable
import platform.Foundation.NSDate

/**
 * Convert a [String] or [Long] date format into a platform specific Date object.
 */
@Serializable(KSerializerClientDate::class)
public actual class ClientDate internal actual constructor(override val raw: String) : Raw<String> {

    internal actual constructor(timestamp: Long) : this(DateISO8601.format(timestamp))

    /**
     * In the eventuality of the Date format being wrong, we return null.
     */
    val date: NSDate? = when (raw.length) {
        20 -> DateISO8601.dateISO8601.parse(raw)
        24 -> DateISO8601.dateISO8601Millis.parse(raw)
        else -> null
    }
}
