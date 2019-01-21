package serialize

import com.algolia.search.saas.data.QueryRule
import com.algolia.search.saas.data.QueryRule.Edit
import com.algolia.search.saas.serialize.*
import kotlinx.serialization.json.json
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import unknown


@RunWith(JUnit4::class)
internal class TestQueryRuleEdit : TestSerializer<QueryRule.Edit>(QueryRule.Edit) {
    override val items = listOf(
        Edit(unknown) to json {
            KeyType to KeyRemove
            KeyDelete to unknown
        },
        Edit(unknown, unknown) to json {
            KeyType to KeyReplace
            KeyDelete to unknown
            KeyInsert to unknown
        }
    )
}