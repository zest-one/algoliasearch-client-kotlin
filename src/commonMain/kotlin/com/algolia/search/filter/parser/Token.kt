package com.algolia.search.filter.parser


enum class Token(val character: Char) {
    DoubleQuotes('"'),
    SingleQuotes('\''),
    OpenParenthesis('('),
    CloseParenthesis(')'),
    Colon(':'),
    Space(' ')
}