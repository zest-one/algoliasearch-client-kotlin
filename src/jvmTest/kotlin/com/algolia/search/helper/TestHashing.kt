package com.algolia.search.helper

import kotlin.test.Test
import kotlin.test.assertEquals

class TestHashingTmp {

    @Test
    fun testSha256() {
        val input = "kotlin client rocks!"
        val encoded = input.sha256("algolia")
        println(encoded)
        assertEquals("a031ed61c8285a9e1aaf8fd45dfba5856c61e61f7956f47fff8224b0ada3cf44", encoded)
    }
}
