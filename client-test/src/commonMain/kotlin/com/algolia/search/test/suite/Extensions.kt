package com.algolia.search.test.suite

import com.algolia.search.helper.toIndexName
import com.algolia.search.model.IndexName
import com.algolia.search.model.analytics.Variant
import com.algolia.search.model.response.ResponseVariant
import com.algolia.search.serialize.internal.JsonDebug
import com.algolia.search.test.DateFormat
import com.algolia.search.test.loadScratch
import com.algolia.search.test.shouldEqual
import com.algolia.search.test.username
import kotlinx.serialization.KSerializer

fun testSuiteIndexName(suffix: String): IndexName {
    val date = DateFormat.format()
    val prefix = "kotlin-$date"

    return "$prefix-$username-$suffix".toIndexName()
}

fun <T> load(serializer: KSerializer<T>, name: String): T {
    val string = loadScratch(name)
    val data = JsonDebug.decodeFromString(serializer, string)
    val serialized = JsonDebug.encodeToString(serializer, data)

    serialized.removeSpaces() shouldEqual string.removeSpaces()
    return data
}

private fun String.removeSpaces() = replace("\\s".toRegex(), "")
