package com.algolia.search.filter.parser


object Tokenizer {

    fun tokenize(expression: String): List<String> {
        var isEscapedDouble = false
        var isEscapedSingle = false
        val tokens = mutableListOf<String>()
        val word = StringBuilder()

        fun addWord() {
            if (word.isNotEmpty()) {
                tokens += word.toString()
                word.clear()
            }
        }

        for (index in 0 until expression.length) {
            val character = expression[index]

            if (isEscapedSingle && character != Token.SingleQuotes.character) {
                word.append(character)
                continue
            }

            if (isEscapedDouble && character != Token.DoubleQuotes.character) {
                word.append(character)
                continue
            }
            when (character) {
                Token.DoubleQuotes.character -> {
                    word.append(character)
                    isEscapedDouble = !isEscapedDouble
                    if (!isEscapedDouble) addWord()
                }
                Token.SingleQuotes.character -> {
                    word.append(character)
                    isEscapedSingle = !isEscapedSingle
                    if (!isEscapedSingle) addWord()
                }
                Token.OpenParenthesis.character,
                Token.CloseParenthesis.character,
                Token.Colon.character -> {
                    addWord()
                    word.append(character)
                    addWord()
                }
                Token.Space.character -> addWord()
                else -> word.append(character)
            }
        }
        addWord()
        return tokens
    }
}