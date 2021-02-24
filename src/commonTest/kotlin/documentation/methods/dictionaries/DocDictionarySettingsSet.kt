package documentation.methods.dictionaries

import com.algolia.search.model.dictionary.DictionarySettings
import com.algolia.search.model.dictionary.DisableStandardEntries
import com.algolia.search.model.search.Language
import documentation.client
import kotlin.test.Ignore
import kotlin.test.Test
import runBlocking

@Ignore
class DocDictionarySettingsSet {

    @Test
    fun snippet() {
        runBlocking {
            val settings = DictionarySettings(
                disableStandardEntries = DisableStandardEntries(
                    stopwords = mapOf(Language.English to true)
                )
            )
            client.setDictionarySettings(settings)
        }
    }
}
