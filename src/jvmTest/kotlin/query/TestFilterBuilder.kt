package query

import com.algolia.search.saas.query.FilterBuilder
import comparisonA
import comparisonB
import facetA
import facetB
import groupAndA
import groupAndB
import groupOrA
import groupOrB
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import shouldBeFalse
import shouldBeTrue
import tagA
import tagB


@RunWith(JUnit4::class)
internal class TestFilterBuilder {

    @Test
    fun isEmpty() {
        FilterBuilder {
            isEmpty().shouldBeTrue()
            groupAndA += facetA
            isEmpty().shouldBeFalse()
        }
    }

    @Test
    fun clear() {
        FilterBuilder {
            groupAndA += facetA
            groupAndB += facetB
            clear()
            isEmpty().shouldBeTrue()
        }
    }

    @Test
    fun print() {
        FilterBuilder {
            groupAndA += facetA
            groupAndA += facetB
            groupAndB += facetA
            groupAndB += facetB
            groupOrA += facetA
            groupOrA += facetB
            groupOrB += facetA
            groupOrB += facetB
            groupOrA += comparisonA
            groupOrA += comparisonB
            groupOrB += comparisonA
            groupOrB += comparisonB
            groupOrA += tagA
            groupOrA += tagB
            groupOrB += tagA
            groupOrB += tagB
        }.printDebug()
    }
}