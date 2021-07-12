package com.algolia.search

import com.algolia.search.client.ClientAnalytics
import com.algolia.search.client.ClientSearch
import com.algolia.search.configuration.Region
import com.algolia.search.helper.toAPIKey
import com.algolia.search.helper.toApplicationID

internal actual val clientAnalytics = ClientAnalytics(
    System.getenv("ALGOLIA_APPLICATION_ID_1").toApplicationID(),
    System.getenv("ALGOLIA_ADMIN_KEY_1").toAPIKey(),
    Region.Analytics.US
)
