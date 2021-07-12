package com.algolia.search.dsl.internal

import com.algolia.search.InternalAlgoliaClientApi
import com.algolia.search.dsl.requestOptions
import com.algolia.search.transport.RequestOptions

/**
 * Request Options Builder.
 */
@InternalAlgoliaClientApi
public fun requestOptionsBuilder(
    requestOptions: RequestOptions? = null,
    block: RequestOptions.() -> Unit,
): RequestOptions = requestOptions(requestOptions, block)
