package com.algolia.search.helper

import shouldEqual
import kotlin.test.Test

class TestHashing {

    @Test
    fun testSha256() {
        val encoded = "1234".sha256("test")
        println(encoded)
        encoded shouldEqual "24c4f0295e1bea74f9a5cb5bc40525c8889d11c78c4255808be00defe666671f"
    }
}
