package suite

import clientRecommendation
import com.algolia.search.model.Attribute
import com.algolia.search.model.insights.EventName
import com.algolia.search.model.personalization.EventScoring
import com.algolia.search.model.personalization.EventType
import com.algolia.search.model.personalization.FacetScoring
import com.algolia.search.model.personalization.PersonalizationStrategy
import runBlocking
import shouldEqual
import kotlin.test.Test


internal class TestSuitePersonalization {

    @Test
    fun test() {
        runBlocking {
            val strategy = PersonalizationStrategy(
                eventsScoring = listOf(
                    EventScoring( EventName("add to cart"), EventType.Conversion, 20),
                    EventScoring(EventName("buy"), EventType.Conversion, 10)
                ),
                facetsScoring = listOf(
                    FacetScoring(Attribute("brand"), 10),
                    FacetScoring(Attribute("category"), 20)
                )
            )
            clientRecommendation.getPersonalizationStrategy().let {
                it.eventsScoring shouldEqual strategy.eventsScoring
                it.facetsScoring shouldEqual strategy.facetsScoring
            }
        }
    }
}