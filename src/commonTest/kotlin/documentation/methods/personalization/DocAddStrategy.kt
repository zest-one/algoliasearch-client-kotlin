package documentation.methods.personalization

import com.algolia.search.client.ClientRecommendation
import com.algolia.search.configuration.Region
import com.algolia.search.model.APIKey
import com.algolia.search.model.ApplicationID
import com.algolia.search.model.Attribute
import com.algolia.search.model.insights.EventName
import com.algolia.search.model.personalization.EventScoring
import com.algolia.search.model.personalization.EventType
import com.algolia.search.model.personalization.FacetScoring
import com.algolia.search.model.personalization.PersonalizationStrategy
import runBlocking
import kotlin.test.Ignore
import kotlin.test.Test


@Ignore
internal class DocAddStrategy {

//    suspend fun ClientRecommendation.setPersonalizationStrategy(
//        #{strategy}: __PersonalizationStrategy__,
//        requestOptions: __RequestOptions?__ = null
//    ): Revision

    @Test
    fun snippet1() {
        runBlocking {
            val client = ClientRecommendation(
                ApplicationID("YourApplicationId"),
                APIKey("YourAdminAPIKey"),
                Region.US
            )
            val strategy = PersonalizationStrategy(
                facetsScoring = listOf(
                    FacetScoring(Attribute("brand"), 100),
                    FacetScoring(Attribute("categories"), 10)
                ),
                eventsScoring = listOf(
                    EventScoring(EventName("Add to cart"), EventType.Conversion, 50),
                    EventScoring(EventName("Purchase"), EventType.Conversion, 100)
                )
            )
            client.setPersonalizationStrategy(strategy)
        }
    }
}