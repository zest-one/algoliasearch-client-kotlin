package com.algolia.search.filter


enum class Token(val regex: Regex) {
    Open(Regex("\\(")),
    Close(Regex("\\)")),
    Facet(Regex("^(?<negation>NOT )?\"?(?<attribute>([^\"]|\")+?)\"?:\"?(?<value>([^\"]|\")+?)\"?$")),
    Tag(Regex("_tags:(.*)")),
    Range(Regex("(.*):(.*) TO (.*)")),
    Comparison(Regex("(.*) (<|<=|=|!=|>=|>) (.*)"))
}