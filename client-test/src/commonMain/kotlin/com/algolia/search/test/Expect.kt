package com.algolia.search.test

import com.algolia.search.client.ClientSearch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlinx.coroutines.CoroutineScope

expect val clientAdmin1: ClientSearch
expect val clientAdmin2: ClientSearch

expect fun runBlocking(
    coroutineContext: CoroutineContext = EmptyCoroutineContext,
    block: suspend CoroutineScope.() -> Unit
)

expect fun loadScratch(name: String): String

expect val username: String

const val dayInMillis: Int = 24 * 60 * 60 * 1000

expect object DateFormat {

    fun format(timestamp: Long? = null): String

    fun parse(date: String): Long
}

expect fun setupTrustStoreType()
