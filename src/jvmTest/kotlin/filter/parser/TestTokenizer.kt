package filter.parser

import com.algolia.search.filter.parser.Tokenizer
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import shouldBeEmpty
import shouldEqual


@RunWith(JUnit4::class)
internal class TestTokenizer {

    @Test
    fun empty() {
        val tokens = Tokenizer.tokenize("")

        tokens.shouldBeEmpty()
    }

    @Test
    fun facet() {
        Tokenizer.tokenize("attribute:value").let {
            it.size shouldEqual 3
            it[0] shouldEqual "attribute"
            it[1] shouldEqual ":"
            it[2] shouldEqual "value"
        }
        Tokenizer.tokenize("\"attribute with space\" : \"value with space\"").let {
            it.size shouldEqual 3
            it[0] shouldEqual "\"attribute with space\""
            it[1] shouldEqual ":"
            it[2] shouldEqual "\"value with space\""
        }
    }

    @Test
    fun range() {
        Tokenizer.tokenize("price>10").let {
            it.size shouldEqual 3
            it[0] shouldEqual "price"
            it[1] shouldEqual ">"
            it[2] shouldEqual "10"
        }
    }

    @Test
    fun doubleQuotes() {
        Tokenizer.tokenize("\"").let {
            it.size shouldEqual 1
            it[0] shouldEqual "\""
        }
        Tokenizer.tokenize("\"word':() \"").let {
            it.size shouldEqual 1
            it[0] shouldEqual "\"word':() \""
        }
    }

    @Test
    fun singleQuotes() {
        Tokenizer.tokenize("'\"word;(): \"'").let {
            it.size shouldEqual 1
            it[0] shouldEqual "'\"word;(): \"'"
        }
    }
}