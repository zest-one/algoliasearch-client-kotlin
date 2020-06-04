import com.algolia.search.client.ClientAnalytics
import com.algolia.search.client.ClientInsights
import com.algolia.search.client.ClientPlaces
import com.algolia.search.client.ClientRecommendation
import com.algolia.search.client.ClientSearch
import com.algolia.search.configuration.Region
import com.algolia.search.model.APIKey
import com.algolia.search.model.ApplicationID
import kotlinx.coroutines.CoroutineScope
import platform.Foundation.NSUserName
import kotlin.coroutines.CoroutineContext
import com.algolia.search.helper.DateFormatter
import kotlin.math.roundToLong

internal actual val clientSearch = ClientSearch(
    ApplicationID("latency"),
    APIKey("1234")
)
internal actual val clientAdmin1 = ClientSearch(
    ApplicationID("latency"),
    APIKey("1234")
)
internal actual val clientAdmin2 = ClientSearch(
    ApplicationID("latency"),
    APIKey("1234")
)
internal actual val clientMcm = ClientSearch(
    ApplicationID("latency"),
    APIKey("1234")
)
internal actual val clientAnalytics = ClientAnalytics(
    ApplicationID("latency"),
    APIKey("1234"),
    Region.Analytics.EU
)
internal actual val clientInsights = ClientInsights(
    ApplicationID("latency"),
    APIKey("1234")
)
internal actual val clientPlaces = ClientPlaces(
    ApplicationID("latency"),
    APIKey("1234")
)
internal actual val clientRecommendation = ClientRecommendation(
    ApplicationID("latency"),
    APIKey("1234"),
    Region.Recommendation.EU
)

internal actual fun runBlocking(
    coroutineContext: CoroutineContext,
    block: suspend CoroutineScope.() -> Unit
) {
    kotlinx.coroutines.runBlocking(coroutineContext, block = block)
}

internal actual fun loadScratch(name: String): String {
    // TODO("Not yet implemented")
    return ""
}

internal actual val username: String
    get() = try {
        NSUserName()
    } catch (exception: Exception) {
        "unknown"
    }

internal actual object DateFormat {

    private val dateFormatter = DateFormatter("YYYY-MM-dd-HH-mm-ss")

    actual fun format(timestamp: Long?): String {
        return timestamp?.let { dateFormatter.stringFromLong(it) } ?: ""
    }

    actual fun parse(date: String): Long {
        return (dateFormatter.parse(date)!!.timeIntervalSinceReferenceDate * 1000L).toLong()
    }
}
