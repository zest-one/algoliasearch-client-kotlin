package com.algolia.search.configuration

import com.algolia.search.configuration.internal.DEFAULT_READ_TIMEOUT
import com.algolia.search.configuration.internal.DEFAULT_WRITE_TIMEOUT
import com.algolia.search.internal.hosts
import com.algolia.search.model.APIKey
import com.algolia.search.model.ApplicationID
import com.algolia.search.test.shouldBeNull
import com.algolia.search.test.shouldEqual
import io.ktor.client.features.logging.LogLevel
import kotlin.test.Test

internal class TestConfiguration {

    private val applicationID = ApplicationID("applicationID")
    private val apiKey = APIKey("apiKey")
    private val regionPersonalization = Region.Personalization.EU

    @Test
    fun configurationPersonalization() {
        ConfigurationPersonalization(applicationID, apiKey, regionPersonalization).apply {
            writeTimeout shouldEqual DEFAULT_WRITE_TIMEOUT
            readTimeout shouldEqual DEFAULT_READ_TIMEOUT
            logLevel shouldEqual LogLevel.NONE
            hosts shouldEqual regionPersonalization.hosts
            defaultHeaders.shouldBeNull()
            engine.shouldBeNull()
            httpClientConfig.shouldBeNull()
        }
    }
}
