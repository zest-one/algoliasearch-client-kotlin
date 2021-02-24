package documentation.methods.dictionaries

import com.algolia.search.endpoint.extension.clearStopwordEntries
import com.algolia.search.model.dictionary.Dictionary
import documentation.client
import kotlin.test.Ignore
import kotlin.test.Test
import runBlocking

@Ignore
class DocDictionaryClearEntries {

    @Test
    fun snippet() {
        runBlocking {
            client.clearDictionaryEntries(Dictionary.Stopwords)
            // or using extension function:
            client.clearStopwordEntries()
        }
    }
}
