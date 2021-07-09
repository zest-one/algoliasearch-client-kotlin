package com.algolia.search.suite

import com.algolia.search.clientPersonalization
import com.algolia.search.model.personalization.EventScoring
import com.algolia.search.model.personalization.FacetScoring
import com.algolia.search.model.personalization.PersonalizationStrategy
import com.algolia.search.model.personalization.SetPersonalizationStrategyResponse
import io.ktor.client.features.ClientRequestException
import io.ktor.http.HttpStatusCode
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking

internal class TestSuitePersonalization {

    @Test
    fun testPersonalizationClient() {
        runBlocking {
            clientPersonalization.getPersonalizationStrategy()
        }
    }

    @Test
    fun testSetStrategyPayload() {
        runBlocking {
            val strategy = PersonalizationStrategy(
                eventsScoring = listOf(
                    EventScoring("Add to cart", "conversion", 50),
                    EventScoring("Purchase", "conversion", 100)
                ),
                facetsScoring = listOf(
                    FacetScoring("brand", 100),
                    FacetScoring("categories", 10)
                ),
                personalizationImpact = 0
            )

            val response = SetPersonalizationStrategyResponse(200, "Strategy was successfully updated")

            try {
                assertEquals(clientPersonalization.setPersonalizationStrategy(strategy), response)
            } catch (e: ClientRequestException) {
                // The personalization API is now limiting the number of setPersonalizationStrategy()` successful calls
                // to 15 per day. If the 429 error is returned, the response is considered a "success".
                if (e.response.status != HttpStatusCode.TooManyRequests) throw e
            }
            assertEquals(clientPersonalization.getPersonalizationStrategy(), strategy)
        }
    }
}
