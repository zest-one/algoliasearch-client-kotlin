package documentation.methods.dictionaries

import com.algolia.search.endpoint.extension.searchStopwordEntries
import com.algolia.search.model.dictionary.Dictionary
import com.algolia.search.model.search.Language
import com.algolia.search.model.search.Query
import documentation.client
import kotlin.test.Ignore
import kotlin.test.Test
import runBlocking

@Ignore
class DocDictionarySearchEntries {

    @Test
    fun snippet() {
        runBlocking {
            val response = client.searchDictionaryEntries(
                dictionary = Dictionary.Stopwords,
                query = Query("und", queryLanguages = listOf(Language.Dutch)))
            // or using extension function:
            val response2 = client.searchStopwordEntries(
                query = Query("und", queryLanguages = listOf(Language.Dutch))
            )
        }
    }
}
