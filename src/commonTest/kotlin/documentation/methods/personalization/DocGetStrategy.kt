package documentation.methods.personalization

import com.algolia.search.client.ClientRecommendation
import com.algolia.search.configuration.Region
import com.algolia.search.model.APIKey
import com.algolia.search.model.ApplicationID
import documentation.client
import runBlocking
import kotlin.test.Ignore
import kotlin.test.Test


@Ignore
internal class DocGetStrategy {

//    suspend fun ClientRecommendation.getPersonalizationStrategy(
//        requestOptions: __RequestOptions?__ = null
//    ): ResponsePersonalizationStrategy

    @Test
    fun snippet1() {
        runBlocking {
            val client = ClientRecommendation(
                ApplicationID("YourApplicationId"),
                APIKey("YourAdminAPIKey"),
                Region.US
            )

            client.getPersonalizationStrategy()
        }
    }
}