package com.algolia.search.model.response

import com.algolia.search.endpoint.EndpointAdvanced
import com.algolia.search.model.Attribute
import com.algolia.search.model.insights.EventName
import com.algolia.search.model.personalization.EventScoring
import com.algolia.search.model.personalization.FacetScoring
import com.algolia.search.model.task.Task
import com.algolia.search.model.task.TaskID
import com.algolia.search.serialize.KeyEventsScoring
import com.algolia.search.serialize.KeyFacetsScoring
import com.algolia.search.serialize.KeyTaskID
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
public data class ResponsePersonalizationStrategy(
    /**
     * [EventScoring] associated to each [EventName].
     */
    @SerialName(KeyEventsScoring) val eventsScoring: List<EventScoring>,
    /**
     * [FacetScoring] associated to each [Attribute].
     */
    @SerialName(KeyFacetsScoring) val facetsScoring: List<FacetScoring>
)