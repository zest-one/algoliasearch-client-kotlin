package documentation.parameters.highlighting

import com.algolia.search.dsl.attributesToSnippet
import com.algolia.search.dsl.query
import com.algolia.search.dsl.settings
import documentation.index
import runBlocking
import kotlin.test.Ignore
import kotlin.test.Test


@Ignore
internal class DocAttributesToSnippet {

//    attributesToSnippet {
//        +"attribute1"
//        +"attribute2"(10) // limits the number of words of the snippet
//    }

    @Test
    fun settings() {
        runBlocking {
            val settings = settings {
                attributesToSnippet {
                    +"content"(80)
                    +"description"
                }
            }

            index.setSettings(settings)
        }
    }

    @Test
    fun settingsAll() {
        runBlocking {
            val settings = settings {
                attributesToSnippet {
                    +"*"(80)
                }
            }

            index.setSettings(settings)
        }
    }

    @Test
    fun query() {
        runBlocking {
            val query = query("query") {
                attributesToSnippet {
                    +"title"
                    +"content"(80)
                }
            }

            index.search(query)
        }
    }
}