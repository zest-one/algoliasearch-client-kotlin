package suite

import clientAdmin1
import clientAnalytics
import com.algolia.search.model.ClientDate
import com.algolia.search.model.analytics.ABTest
import com.algolia.search.model.analytics.ABTestStatus
import com.algolia.search.model.analytics.Variant
import com.algolia.search.model.internal.Time
import com.algolia.search.model.task.TaskStatus
import com.algolia.search.serialize.KeyObjectID
import dayInMillis
import io.ktor.client.features.ResponseException
import io.ktor.http.HttpStatusCode
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.put
import runBlocking
import shouldEqual
import shouldFailWith
import shouldNotBeNull
import shouldNotEqual
import kotlin.test.Test

