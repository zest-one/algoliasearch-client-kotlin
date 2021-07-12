package com.algolia.search.configuration

import com.algolia.search.configuration.internal.DEFAULT_READ_TIMEOUT
import com.algolia.search.configuration.internal.DEFAULT_WRITE_TIMEOUT
import com.algolia.search.internal.hosts
import com.algolia.search.model.APIKey
import com.algolia.search.model.ApplicationID
import io.ktor.client.features.logging.LogLevel
import kotlin.test.Test
import kotlin.test.assertEquals

internal class TestConfiguration {

    private val applicationID = ApplicationID("applicationID")
    private val apiKey = APIKey("apiKey")
    private val regionAnalytics = Region.Analytics.EU

    @Test
    fun configurationAnalytics() {
        ConfigurationAnalytics(applicationID, apiKey, regionAnalytics).apply {
            assertEquals(writeTimeout, DEFAULT_WRITE_TIMEOUT)
            assertEquals(readTimeout, DEFAULT_READ_TIMEOUT)
            assertEquals(logLevel, LogLevel.NONE)
            assertEquals(hosts, regionAnalytics.hosts)
            assertEquals(defaultHeaders, null)
            assertEquals(engine, null)
            assertEquals(httpClientConfig, null)
        }
    }
}
