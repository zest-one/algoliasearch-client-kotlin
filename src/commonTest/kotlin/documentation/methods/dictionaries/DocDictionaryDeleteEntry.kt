package documentation.methods.dictionaries

import com.algolia.search.endpoint.extension.deleteStopwordEntries
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
class DocDictionaryDeleteEntry {

    @Test
    fun snippet() {
        runBlocking {
            val objectID = ObjectID("MyObjectID")
            client.deleteDictionaryEntries(Dictionary.Stopwords, listOf(objectID))
            // or using extension function:
            client.deleteStopwordEntries(listOf(objectID))
        }
    }
}
