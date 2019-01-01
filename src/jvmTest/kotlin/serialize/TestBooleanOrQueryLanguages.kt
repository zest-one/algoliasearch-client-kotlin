package serialize

import boolean
import client.data.BooleanOrQueryLanguages
import client.data.BooleanOrQueryLanguages.Boolean
import client.data.BooleanOrQueryLanguages.QueryLanguages
import client.data.QueryLanguage.Afrikaans
import client.data.QueryLanguage.Albanian
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonArray
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
internal class TestBooleanOrQueryLanguages : TestSerializer<BooleanOrQueryLanguages>(BooleanOrQueryLanguages) {

    override val item = listOf(
        Boolean(boolean) to JsonPrimitive(boolean),
        QueryLanguages(
            Afrikaans,
            Albanian
        ) to jsonArray {
            +Afrikaans.raw
            +Albanian.raw
        }
    )
}