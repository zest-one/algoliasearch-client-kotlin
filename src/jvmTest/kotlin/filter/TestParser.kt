package filter

import com.algolia.search.filter.FilterFacet
import com.algolia.search.filter.Token
import com.algolia.search.helper.toAttribute
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import shouldEqual
import shouldNotBeNull


@RunWith(JUnit4::class)
internal class TestParser {

    private fun MatchResult.facet(): Triple<MatchGroup?, MatchGroup?, MatchGroup?> {
        return Triple(
            groups["negation"],
            groups["attribute"],
            groups["value"]
        )
    }

    @Test
    fun facet() {
        val valueRaw = "\"    \"\""

        FilterFacet("oh my \" brain".toAttribute(), valueRaw).not().let {
            val result = Token.Facet.regex.find(it.build())
            val (negation, attribute, value) = result.shouldNotBeNull().facet()

            negation.shouldNotBeNull()
            attribute.shouldNotBeNull()
            value.shouldNotBeNull()
            result.groups[0]!!.value shouldEqual it.build()
            attribute.value shouldEqual it.attribute.raw
            value.value shouldEqual valueRaw

            FilterFacet(attribute.value.toAttribute(), value.value).not() shouldEqual it
        }
    }
}