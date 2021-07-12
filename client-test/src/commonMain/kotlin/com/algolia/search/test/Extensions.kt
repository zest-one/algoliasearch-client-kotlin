package com.algolia.search.test

import com.algolia.search.model.Attribute
import com.algolia.search.model.IndexName
import com.algolia.search.model.ObjectID
import com.algolia.search.model.filter.Filter
import kotlinx.serialization.json.add
import kotlinx.serialization.json.buildJsonArray

fun set(vararg filters: Filter) = mutableSetOf(*filters)

const val unknown = "unknown"
const val int = 0
const val boolean = true
const val string = "string"
val attributeA = Attribute("attributeA")
val attributeB = Attribute("attributeB")
val indexA = IndexName("indexA")
val indexB = IndexName("indexB")
val objectIDA = ObjectID("442854")
val objectIDB = ObjectID("322601")
val nestedLists = listOf(listOf(string), listOf(string))
val attributes = listOf(attributeA, attributeB)

val nestedListsJson = buildJsonArray {
    add(buildJsonArray { add(string) })
    add(buildJsonArray { add(string) })
}

val attributesJson = buildJsonArray {
    add(attributeA.raw)
    add(attributeB.raw)
}
