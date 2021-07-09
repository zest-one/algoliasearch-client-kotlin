package com.algolia.search

import com.algolia.search.client.ClientPersonalization
import com.algolia.search.configuration.Region
import com.algolia.search.helper.toAPIKey
import com.algolia.search.helper.toApplicationID

internal actual val clientPersonalization = ClientPersonalization(
    System.getenv("ALGOLIA_APPLICATION_ID_1").toApplicationID(),
    System.getenv("ALGOLIA_ADMIN_KEY_1").toAPIKey(),
    Region.Personalization.EU
)
