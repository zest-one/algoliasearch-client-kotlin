package documentation.methods.dictionaries

import com.algolia.search.endpoint.extension.deleteStopwordEntries
import com.algolia.search.model.ObjectID
import com.algolia.search.model.dictionary.Dictionary
import documentation.client
import kotlin.test.Ignore
import kotlin.test.Test
import runBlocking

@Ignore
class DocDictionaryDeleteEntries {

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
