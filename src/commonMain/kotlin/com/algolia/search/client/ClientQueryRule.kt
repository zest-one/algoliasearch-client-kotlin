package com.algolia.search.client

import com.algolia.search.endpoint.EndpointQueryRule
import com.algolia.search.model.IndexName
import com.algolia.search.model.ObjectID
import com.algolia.search.model.queryrule.QueryRule
import com.algolia.search.model.queryrule.QueryRuleResponse
import com.algolia.search.serialize.KeyClearExistingRules
import com.algolia.search.serialize.KeyQuery
import com.algolia.search.serialize.encodeNoNulls
import com.algolia.search.serialize.toJsonObject
import io.ktor.client.request.*
import kotlinx.serialization.json.json
import kotlinx.serialization.json.jsonArray


internal class ClientQueryRule(
    val client: Client,
    override val indexName: IndexName
) : EndpointQueryRule,
    Client by client {

    override suspend fun saveRule(
        queryRule: QueryRule,
        forwardToReplicas: Boolean?,
        requestOptions: RequestOptions?
    ): QueryRuleResponse.Update {
        return write.retry(
            requestOptions.computedReadTimeout,
            indexName.pathIndexes("/rules/${queryRule.objectID}")
        ) { path ->
            httpClient.put<QueryRuleResponse.Update>(path) {
                setRequestOptions(requestOptions)
                setForwardToReplicas(forwardToReplicas)
                body = queryRule.toJsonObject(QueryRule.serializer()).encodeNoNulls().toString()
            }
        }
    }

    override suspend fun getRule(objectID: ObjectID, requestOptions: RequestOptions?): QueryRule {
        return read.retry(requestOptions.computedReadTimeout, indexName.pathIndexes("/rules/$objectID")) { path ->
            httpClient.get<QueryRule>(path) {
                setRequestOptions(requestOptions)
            }
        }
    }

    override suspend fun deleteRule(
        objectID: ObjectID,
        forwardToReplicas: Boolean?,
        requestOptions: RequestOptions?
    ): QueryRuleResponse.Update {
        return write.retry(requestOptions.computedWriteTimeout, indexName.pathIndexes("/rules/$objectID")) { path ->
            httpClient.delete<QueryRuleResponse.Update>(path) {
                setRequestOptions(requestOptions)
                setForwardToReplicas(forwardToReplicas)
            }
        }
    }

    override suspend fun searchRules(query: String?, requestOptions: RequestOptions?): QueryRuleResponse.Search {
        return read.retry(requestOptions.computedReadTimeout, indexName.pathIndexes("/rules/search")) { path ->
            httpClient.post<QueryRuleResponse.Search>(path) {
                setRequestOptions(requestOptions)
                body = json { query?.let { KeyQuery to it } }.toString()
            }
        }
    }

    override suspend fun clearRules(forwardToReplicas: Boolean?, requestOptions: RequestOptions?): QueryRuleResponse.Update {
        return write.retry(requestOptions.computedWriteTimeout, indexName.pathIndexes("/rules/clear")) { path ->
            httpClient.post<QueryRuleResponse.Update>(path) {
                setRequestOptions(requestOptions)
                setForwardToReplicas(forwardToReplicas)
                body = ""
            }
        }
    }

    override suspend fun saveRules(
        queryRules: List<QueryRule>,
        forwardToReplicas: Boolean?,
        clearExistingRules: Boolean?,
        requestOptions: RequestOptions?
    ): QueryRuleResponse.Update {
        return write.retry(requestOptions.computedWriteTimeout, indexName.pathIndexes("/rules/batch")) { path ->
            httpClient.post<QueryRuleResponse.Update>(path) {
                setRequestOptions(requestOptions)
                setForwardToReplicas(forwardToReplicas)
                clearExistingRules?.let { parameter(KeyClearExistingRules, it) }
                body = jsonArray {
                    queryRules.forEach { +it.toJsonObject(QueryRule.serializer()).encodeNoNulls() }
                }.toString()
            }
        }
    }
}