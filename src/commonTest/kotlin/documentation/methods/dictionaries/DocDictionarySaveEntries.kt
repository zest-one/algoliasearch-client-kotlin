package documentation.methods.dictionaries

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
class DocDictionarySaveEntries {

    @Test
    fun snippetStopword() {
        runBlocking {
            val entry = DictionaryEntry.Stopword(
                objectID = ObjectID("MyObjectID"),
                language = Language.English,
                word = "upper"
            )
            client.saveDictionaryEntries(Dictionary.Stopwords, listOf(entry))
            // or using extension function:
            client.saveStopwordEntries(listOf(entry))
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
            client.saveDictionaryEntries(Dictionary.Plurals, listOf(entry))
            // or using extension function:
            client.savePluralEntries(listOf(entry))
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
            client.saveDictionaryEntries(Dictionary.Compounds, listOf(entry))
            // or using extension function:
            client.saveCompoundEntries(listOf(entry))
        }
    }
}
