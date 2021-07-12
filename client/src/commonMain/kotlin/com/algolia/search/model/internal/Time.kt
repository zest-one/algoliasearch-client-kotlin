package com.algolia.search.model.internal

import com.algolia.search.InternalAlgoliaClientApi

@InternalAlgoliaClientApi
public expect object Time {

    public fun getCurrentTimeMillis(): Long
}
