package com.algolia.search.internal.transport

import com.algolia.search.configuration.Region
import com.algolia.search.configuration.RetryableHost

internal val Region.Personalization.hosts: List<RetryableHost>
    get() = listOf(RetryableHost("personalization.$this.algolia.com"))
