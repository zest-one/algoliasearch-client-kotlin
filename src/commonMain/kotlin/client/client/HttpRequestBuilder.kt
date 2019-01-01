package client.client

import client.data.*
import client.serialize.*
import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import kotlinx.serialization.json.json
import kotlinx.serialization.json.jsonArray


fun HttpRequestBuilder.setApplicationId(applicationId: ApplicationId) {
    header("X-Algolia-Application-Id", applicationId.name)
}

fun HttpRequestBuilder.setApiKey(apiKey: ApiKey) {
    header("X-Algolia-API-Key", apiKey.name)
}

fun HttpRequestBuilder.setRequestOptions(requestOptions: RequestOptions?) {
    requestOptions?.headers?.forEach { header(it.key, it.value) }
    requestOptions?.urlParameters?.forEach { parameter(it.key, it.value) }
}

fun HttpRequestBuilder.setQueries(queries: Collection<IndexQuery>, strategy: MultipleQueriesStrategy) {
    body = json {
        KeyRequests to jsonArray {
            queries.forEach {
                +json {
                    KeyIndexName to it.indexName.raw
                    KeyParams to it.query.encodeNoNulls().urlEncode()
                }
            }
        }
        KeyStrategy to strategy.raw
    }.toString()
}

fun HttpRequestBuilder.setBody(query: Query?) {
    body = query?.encodeNoNulls() ?: "{}"
}