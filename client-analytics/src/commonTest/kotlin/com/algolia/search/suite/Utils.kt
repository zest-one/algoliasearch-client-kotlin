package com.algolia.search.suite

import com.algolia.search.client.ClientSearch
import com.algolia.search.clientAnalytics
import com.algolia.search.model.analytics.Variant
import com.algolia.search.model.internal.Time
import com.algolia.search.model.response.ResponseVariant
import com.algolia.search.test.DateFormat
import com.algolia.search.test.dayInMillis
import com.algolia.search.test.shouldEqual
import com.algolia.search.test.username

internal suspend fun cleanIndex(client: ClientSearch, suffix: String, now: Boolean = false) {
    client.listIndices().items.forEach {
        val indexName = it.indexName.raw

        if (indexName.contains("kotlin")) {
            val result = Regex("kotlin-(.*)-$username-$suffix").find(indexName)
            val date = result?.groupValues?.get(1)
            if (date != null) {
                val difference = Time.getCurrentTimeMillis() - DateFormat.parse(date)

                if (difference >= dayInMillis || now) {
                    val index = client.initIndex(it.indexName)
                    if (it.abTestOrNull != null) {
                        index.apply {
                            clientAnalytics.deleteABTest(it.abTest.abTestId).wait()
                        }
                    }
                    index.apply { deleteIndex().wait() }
                }
            }
        }
    }
}

infix fun ResponseVariant.compareEqual(expected: Variant) {
    indexName shouldEqual expected.indexName
    trafficPercentage shouldEqual expected.trafficPercentage
    description shouldEqual expected.description
}
