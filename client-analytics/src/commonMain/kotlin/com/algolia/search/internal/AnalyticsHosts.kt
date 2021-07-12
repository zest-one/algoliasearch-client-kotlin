package com.algolia.search.internal

import com.algolia.search.configuration.Region
import com.algolia.search.configuration.RetryableHost

internal val Region.Analytics.hosts get() = listOf(RetryableHost("analytics.$this.algolia.com"))
