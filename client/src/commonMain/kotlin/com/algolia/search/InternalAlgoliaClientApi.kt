package com.algolia.search

/**
 * Marks declarations that are internal in Algolia Client API, which means that should not be used outside
 * of `com.algolia.search`, because their signatures and semantics will change between future releases without
 * any warnings and without providing any migration aids.
 */
@RequiresOptIn(
    level = RequiresOptIn.Level.ERROR,
    message = "This is internal API Algolia API Client, please don't rely on it."
)
public annotation class InternalAlgoliaClientApi
