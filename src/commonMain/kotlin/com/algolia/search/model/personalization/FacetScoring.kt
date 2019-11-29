package com.algolia.search.model.personalization

import com.algolia.search.model.Attribute
import com.algolia.search.serialize.KeyFacetName
import com.algolia.search.serialize.KeyScore
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
public data class FacetScoring(
    /**
     * The name of the facet
     */
    @SerialName(KeyFacetName) val facetName: Attribute,
    /**
     * The score to associate with a facet.
     */
    @SerialName(KeyScore) val score: Int
)