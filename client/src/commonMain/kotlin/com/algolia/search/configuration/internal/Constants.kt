package com.algolia.search.configuration.internal

import com.algolia.search.InternalAlgoliaClientApi
import io.ktor.client.features.logging.LogLevel

@InternalAlgoliaClientApi
public const val DEFAULT_WRITE_TIMEOUT: Long = 30000L

@InternalAlgoliaClientApi
public const val DEFAULT_READ_TIMEOUT: Long = 5000L

@InternalAlgoliaClientApi
public val DEFAULT_LOG_LEVEL: LogLevel = LogLevel.NONE
