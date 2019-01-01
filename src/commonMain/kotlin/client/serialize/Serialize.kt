package client.serialize

import client.data.Query
import client.data.Settings
import io.ktor.http.Parameters
import io.ktor.http.formUrlEncode
import kotlinx.serialization.Decoder
import kotlinx.serialization.json.*

internal val regexAsc = Regex("$KeyAsc\\((.*)\\)")
internal val regexDesc = Regex("$KeyDesc\\((.*)\\)")
internal val regexEqualOnly = Regex("$KeyEqualOnly\\((.*)\\)")
internal val regexSnippet = Regex("(.*):(\\d+)")

internal fun JsonObject.urlEncode(): String {
    return Parameters.build {
        entries.forEach { (key, element) ->
            when (element) {
                is JsonArray -> appendAll(key, element.content.map { it.content })
                else -> append(key, element.content)
            }
        }
    }.formUrlEncode()
}

internal fun Decoder.readAsTree() = (this as JSON.JsonInput).readAsTree()

internal fun Query.toJsonObject(): JsonObject {
    return JsonTreeMapper().writeTree(this, Query.serializer()).jsonObject
}

internal fun Settings.toJsonObject(): JsonObject {
    return JsonTreeMapper().writeTree(this, Settings.serializer()).jsonObject
}

internal fun Query.encodeNoNulls(): JsonObject {
    return JsonObject(toJsonObject().filter { it.value != JsonNull })
}

internal fun Settings.encodeNoNulls(): JsonObject {
    return JsonObject(toJsonObject().filter { it.value != JsonNull })
}