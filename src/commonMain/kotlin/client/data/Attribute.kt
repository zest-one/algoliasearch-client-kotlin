package client.data

import client.serialize.readAsTree
import client.toAttribute
import kotlinx.serialization.*
import kotlinx.serialization.json.JSON
import kotlinx.serialization.json.JsonLiteral
import kotlinx.serialization.json.JsonPrimitive


@Serializable(Attribute.Companion::class)
data class Attribute(override val raw: String) : RawString {

    override fun toString(): String {
        return raw
    }

    @Serializer(Attribute::class)
    internal companion object : KSerializer<Attribute> {

        override fun serialize(output: Encoder, obj: Attribute) {
            val json = output as JSON.JsonOutput

            json.writeTree(JsonPrimitive(obj.raw))
        }

        override fun deserialize(input: Decoder): Attribute {
            val element = input.readAsTree() as JsonLiteral

            return element.content.toAttribute()
        }
    }
}