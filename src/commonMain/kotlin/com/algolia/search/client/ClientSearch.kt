package com.algolia.search.client

import com.algolia.search.endpoint.EndpointSearch
import com.algolia.search.model.Attribute
import com.algolia.search.model.IndexName
import com.algolia.search.model.search.Cursor
import com.algolia.search.model.search.Query
import com.algolia.search.model.search.SearchResponse
import com.algolia.search.query.clone
import com.algolia.search.serialize.KeyCursor
import com.algolia.search.serialize.KeyFacetQuery
import com.algolia.search.serialize.KeyMaxFacetHits
import com.algolia.search.serialize.encodeNoNulls
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.json


internal class ClientSearch(
    val client: Client,
    override val indexName: IndexName
) : EndpointSearch,
    Client by client {

    private suspend fun search(requestOptions: RequestOptions?): SearchResponse.Search {
        return read.retry(requestOptions.computedReadTimeout, indexName.pathIndexes()) { path ->
            httpClient.get<SearchResponse.Search>(path) {
                setRequestOptions(requestOptions)
            }
        }
    }

    override suspend fun search(query: Query?, requestOptions: RequestOptions?): SearchResponse.Search {
        val copy = query?.clone()

        return read.retry(requestOptions.computedReadTimeout, indexName.pathIndexes("/query")) { path ->
            httpClient.post<SearchResponse.Search>(path) {
                setRequestOptions(requestOptions)
                setBody(copy)
            }
        }
    }

    override suspend fun browse(query: Query?, requestOptions: RequestOptions?): SearchResponse.Search {
        val copy = query?.clone()

        return read.retry(requestOptions.computedReadTimeout, indexName.pathIndexes("/browse")) { path ->
            httpClient.post<SearchResponse.Search>(path) {
                setRequestOptions(requestOptions)
                setBody(copy)
            }
        }
    }

    override suspend fun browse(cursor: Cursor, requestOptions: RequestOptions?): SearchResponse.Search {
        return read.retry(requestOptions.computedReadTimeout, indexName.pathIndexes("/browse")) { path ->
            httpClient.get<SearchResponse.Search>(path) {
                setRequestOptions(requestOptions)
                parameter(KeyCursor, cursor)
            }
        }
    }

    override suspend fun searchForFacetValue(
        attribute: Attribute,
        facetQuery: String?,
        query: Query?,
        maxFacetHits: Int?,
        requestOptions: RequestOptions?
    ): SearchResponse.Facets {
        val copy = query?.clone()

        return read.retry(
            requestOptions.computedReadTimeout,
            indexName.pathIndexes("/facets/$attribute/query")
        ) { path ->
            httpClient.post<SearchResponse.Facets>(path) {
                setRequestOptions(requestOptions)
                val extraParams = json {
                    maxFacetHits?.let { KeyMaxFacetHits to it }
                    facetQuery?.let { KeyFacetQuery to it }
                }

                body = if (copy != null) {
                    val serialize = copy.encodeNoNulls()
                    val map = serialize.toMutableMap()

                    map.putAll(extraParams)
                    JsonObject(map)
                } else {
                    extraParams
                }.toString()
            }
        }
    }
}