package com.algolia.search.suite

import com.algolia.search.clientAnalytics
import com.algolia.search.model.ClientDate
import com.algolia.search.model.analytics.ABTest
import com.algolia.search.model.analytics.ABTestStatus
import com.algolia.search.model.analytics.Variant
import com.algolia.search.model.internal.Time
import com.algolia.search.model.search.IgnorePlurals
import com.algolia.search.model.search.Query
import com.algolia.search.model.task.TaskStatus
import com.algolia.search.serialize.KeyObjectID
import com.algolia.search.test.clientAdmin1
import com.algolia.search.test.dayInMillis
import com.algolia.search.test.runBlocking
import com.algolia.search.test.setupTrustStoreType
import com.algolia.search.test.shouldEqual
import com.algolia.search.test.shouldNotEqual
import com.algolia.search.test.suite.testSuiteIndexName
import kotlin.test.Test
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put

internal class TestSuiteAATest {

    private val suffix = "aa_testing"
    private val indexName = testSuiteIndexName(suffix)
    private val index = clientAdmin1.initIndex(indexName)
    private val data = buildJsonObject { put(KeyObjectID, "one") }
    private val abTest = ABTest(
        name = indexName.raw,
        endAt = ClientDate(Time.getCurrentTimeMillis() + dayInMillis),
        variantA = Variant(indexName, 90),
        variantB = Variant(
            indexName,
            10,
            customSearchParameters = Query(ignorePlurals = IgnorePlurals.True)
        )
    )

    init {
        setupTrustStoreType()
    }

    @Test
    fun test() {
        runBlocking {
            index.apply {
                saveObject(data).wait() shouldEqual TaskStatus.Published
                val response = clientAnalytics.addABTest(abTest)

                response.wait() shouldEqual TaskStatus.Published
                clientAnalytics.getABTest(response.abTestID).let {
                    it.name shouldEqual abTest.name
                    it.endAt shouldEqual abTest.endAt
                    it.name shouldEqual abTest.name
                    it.endAt shouldEqual abTest.endAt
                    it.status shouldNotEqual ABTestStatus.Stopped
                    it.variantA compareEqual abTest.variantA
                    it.variantB compareEqual abTest.variantB
                }
            }
        }
    }
}
