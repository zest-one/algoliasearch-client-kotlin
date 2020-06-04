package com.algolia.search.transport

import io.ktor.http.ContentType.Application.GZip
import io.ktor.util.Identity.encode
import io.ktor.util.KtorExperimentalAPI
import io.ktor.util.toByteArray
import io.ktor.utils.io.ByteReadChannel
import kotlinx.coroutines.runBlocking

internal actual object Gzip : (String) -> ByteArray {

    @OptIn(KtorExperimentalAPI::class)
    override fun invoke(input: String): ByteArray {
        return runBlocking {
            GZip.run {
                encode(ByteReadChannel(input)).toByteArray()
            }
        }
    }
}
