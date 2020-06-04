package com.algolia.search.helper

import kotlin.test.Test
import kotlin.test.assertEquals

class TestEncodeUTF8 {

    @Test
    fun encodeUTF8() {
        val encoded = "example.com/?val1=my name&val2=@%".encodeUTF8()
        val expected = "example.com%2F%3Fval1%3Dmy+name%26val2%3D%40%25"
        assertEquals(expected, encoded)
    }
}
