package documentation.methods.dictionaries

import documentation.client
import kotlin.test.Ignore
import kotlin.test.Test
import runBlocking

@Ignore
class DocDictionarySettingsGet {

    @Test
    fun snippet() {
        runBlocking {
            val settings = client.getDictionarySettings()
        }
    }
}
