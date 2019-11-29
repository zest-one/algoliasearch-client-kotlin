package com.algolia.search.client

import com.algolia.search.configuration.*
import com.algolia.search.endpoint.EndpointPersonalization
import com.algolia.search.endpoint.EndpointPersonalizationImpl
import com.algolia.search.model.APIKey
import com.algolia.search.model.ApplicationID
import com.algolia.search.transport.Transport
import io.ktor.client.features.logging.LogLevel


public class ClientRecommendation private constructor(
    private val transport: Transport
) : EndpointPersonalization by EndpointPersonalizationImpl(transport),
    Configuration by transport,
    Credentials by transport.credentials {

    public constructor(
        applicationID: ApplicationID,
        apiKey: APIKey,
        region: Region,
        logLevel: LogLevel = defaultLogLevel
    ) : this(
        Transport(
            ConfigurationRecommendation(applicationID, apiKey, region, logLevel = logLevel),
            CredentialsImpl(applicationID, apiKey)
        )
    )

    public constructor(
        configuration: ConfigurationRecommendation
    ) : this(Transport(configuration, configuration))
}