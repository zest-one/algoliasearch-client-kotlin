package documentation.methods.dictionaries

import com.algolia.search.endpoint.extension.replaceCompoundEntries
import com.algolia.search.endpoint.extension.replacePluralEntries
import com.algolia.search.endpoint.extension.replaceStopwordEntries
import com.algolia.search.endpoint.extension.saveCompoundEntries
import com.algolia.search.endpoint.extension.savePluralEntries
import com.algolia.search.endpoint.extension.saveStopwordEntries
import com.algolia.search.model.ObjectID
import com.algolia.search.model.dictionary.Dictionary
import com.algolia.search.model.dictionary.DictionaryEntry
import com.algolia.search.model.search.Language
import documentation.client
import kotlin.test.Ignore
import kotlin.test.Test
import runBlocking

@Ignore
class DocDictionaryReplaceEntries {

    @Test
    fun snippetStopword() {
        runBlocking {
            val entry = DictionaryEntry.Stopword(
                objectID = ObjectID("MyObjectID"),
                language = Language.English,
                word = "upper"
            )
            client.replaceDictionaryEntries(Dictionary.Stopwords, listOf(entry))
            // or using extension function:
            client.replaceStopwordEntries(listOf(entry))
        }
    }

    @Test
    fun snippetPlural() {
        runBlocking {
            val entry = DictionaryEntry.Plural(
                objectID = ObjectID("MyObjectID"),
                language = Language.French,
                words = listOf("cheval", "chevaux")
            )
            client.replaceDictionaryEntries(Dictionary.Plurals, listOf(entry))
            // or using extension function:
            client.replacePluralEntries(listOf(entry))
        }
    }

    @Test
    fun snippetCompound() {
        runBlocking {
            val entry = DictionaryEntry.Compound(
                objectID = ObjectID("MyObjectID"),
                language = Language.Dutch,
                word = "kopfschmerztablette",
                decomposition = listOf("kopf", "schmerz", "tablette")
            )
            client.replaceDictionaryEntries(Dictionary.Compounds, listOf(entry))
            // or using extension function:
            client.replaceCompoundEntries(listOf(entry))
        }
    }
}
