package com.algolia.search.test

import com.algolia.search.client.ClientSearch
import com.algolia.search.configuration.Compression
import com.algolia.search.configuration.ConfigurationSearch
import com.algolia.search.helper.toAPIKey
import com.algolia.search.helper.toApplicationID
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.TimeZone
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope

actual val clientAdmin1: ClientSearch = ClientSearch(
    System.getenv("ALGOLIA_APPLICATION_ID_1").toApplicationID(),
    System.getenv("ALGOLIA_ADMIN_KEY_1").toAPIKey()
)
actual val clientAdmin2: ClientSearch = ClientSearch(
    ConfigurationSearch(
        System.getenv("ALGOLIA_APPLICATION_ID_2").toApplicationID(),
        System.getenv("ALGOLIA_ADMIN_KEY_2").toAPIKey(),
        compression = Compression.None
    )
)

actual val username: String
    get() {
        return try {
            System.getProperty("user.name")
        } catch (exception: Exception) {
            "unknown"
        }
    }

actual fun runBlocking(coroutineContext: CoroutineContext, block: suspend CoroutineScope.() -> Unit) {
    kotlinx.coroutines.runBlocking(coroutineContext, block = block)
}

actual object DateFormat {

    private val dateFormat = SimpleDateFormat("YYYY-MM-dd-HH-mm-ss").also {
        it.timeZone = TimeZone.getTimeZone("UTC")
    }

    actual fun format(timestamp: Long?): String {
        return dateFormat.format(if (timestamp != null) Date(timestamp) else Date())
    }

    actual fun parse(date: String): Long {
        return dateFormat.parse(date).time
    }
}

actual fun loadScratch(name: String): String {
    return if (File("src/commonTest/resources").exists()) {
        File("src/commonTest/resources/$name").readText()
    } else {
        File("../../src/commonTest/resources/$name").readText()
    }
}

actual fun setupTrustStoreType() {
    System.setProperty("javax.net.ssl.trustStoreType", "JKS")
}
