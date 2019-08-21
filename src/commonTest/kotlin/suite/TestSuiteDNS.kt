package suite

import clientAdmin1
import com.algolia.search.client.ClientSearch
import com.algolia.search.configuration.ConfigurationSearch
import com.algolia.search.configuration.RetryableHost
import com.algolia.search.model.ApplicationID
import com.algolia.search.model.IndexName
import com.algolia.search.model.response.ResponseSearch
import com.algolia.search.serialize.Json
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.respond
import io.ktor.client.features.logging.LogLevel
import io.ktor.http.ContentType
import io.ktor.http.headersOf
import kotlinx.coroutines.delay
import kotlinx.coroutines.io.ByteReadChannel
import runBlocking
import shouldBeFalse
import shouldBeTrue
import shouldEqual
import kotlin.test.Test


internal class TestSuiteDNS {

    private val readTimeout = 500L
    private val shouldTimeout = 600L
    private val shouldNotTimeout = 400L
    private val mockEngine = MockEngine {
        val delay = if (it.url.host == "algolia.biz") shouldTimeout else shouldNotTimeout

        delay(delay)
        content
    }

    private val content = respond(
        headers = headersOf(
            "Content-Type",
            listOf(ContentType.Application.Json.toString())
        ),
        content = ByteReadChannel(Json.stringify(ResponseSearch.serializer(), ResponseSearch()))
    )
    private val appID = clientAdmin1.applicationID
    private val client = ClientSearch(
        ConfigurationSearch(
            clientAdmin1.applicationID,
            clientAdmin1.apiKey,
            readTimeout = readTimeout,
            engine = mockEngine,
            hosts = listOf(
                RetryableHost("algolia.biz"),
                RetryableHost("$appID-1.algolianet.com"),
                RetryableHost("$appID-2.algolianet.com"),
                RetryableHost("$appID-3.algolianet.com")
            ),
            logLevel = LogLevel.INFO
        )
    )

    @Test
    fun test() {
        runBlocking {
            val index = client.initIndex(IndexName("test"))

            index.search()
            client.transport.apply {
                hosts[0].retryCount shouldEqual 1
                hosts[1].retryCount shouldEqual 0
                hosts[2].retryCount shouldEqual 0
                hosts[3].retryCount shouldEqual 0
            }
        }
    }
}