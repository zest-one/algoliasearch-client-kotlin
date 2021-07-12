package com.algolia.search.model

import com.algolia.search.InternalAlgoliaClientApi
import com.algolia.search.helper.internal.DateISO8601
import com.algolia.search.model.internal.Raw
import com.algolia.search.serialize.KSerializerClientDate
import kotlinx.serialization.Serializable

/**
 * Convert a [String] or [Long] date format into a platform specific Date object.
 */
@Serializable(KSerializerClientDate::class)
public expect class ClientDate internal constructor(raw: String) : Raw<String>

@InternalAlgoliaClientApi
public fun ClientDate(timestamp: Long): ClientDate {
    return ClientDate(DateISO8601.format(timestamp, false))
}
