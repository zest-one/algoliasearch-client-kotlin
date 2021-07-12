package com.algolia.search.test

import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

infix fun <T> T.shouldEqual(expected: T) {
    assertEquals(expected, this)
}

infix fun <T> T.shouldNotEqual(expected: T) {
    assertNotEquals(expected, this)
}

fun Any?.shouldBeNull() {
    assertNull(this)
}

fun Any?.shouldNotBeNull() {
    assertNotNull(this)
}

fun Boolean.shouldBeTrue() {
    assertTrue(this)
}

fun Boolean.shouldBeFalse() {
    assertFalse(this)
}

infix fun <T> Collection<T>?.shouldContain(element: T) {
    (this?.contains(element) ?: false).shouldBeTrue()
}

infix fun <T> Collection<T>?.shouldNotContain(element: T) {
    (this?.contains(element) ?: false).shouldBeFalse()
}

fun <T> Collection<T>.shouldBeEmpty() {
    this.isEmpty().shouldBeTrue()
}

fun <T> Collection<T>.shouldNotBeEmpty() {
    this.isNotEmpty().shouldBeTrue()
}

infix fun <K, V> Map<K, V>?.shouldContainKey(key: K) {
    (this?.containsKey(key) ?: false).shouldBeTrue()
}

infix fun <K, V> Map<K, V>?.shouldNotContainKey(key: K) {
    (this?.containsKey(key) ?: false).shouldBeFalse()
}

infix fun <K, V> Map<K, V>?.shouldContainValue(value: V) {
    (this?.containsValue(value) ?: false).shouldBeTrue()
}

infix fun <K, V> Map<K, V>?.shouldNotContainValue(value: V) {
    (this?.containsValue(value) ?: false).shouldBeFalse()
}

fun <K, V> Map<K, V>.shouldBeEmpty() {
    this.isEmpty().shouldBeTrue()
}

fun <K, V> Map<K, V>.shouldNotBeEmpty() {
    this.isNotEmpty().shouldBeTrue()
}

inline fun <reified T : Throwable> shouldFailWith(noinline block: suspend () -> Unit): T {
    return assertFailsWith(T::class, null) {
        runBlocking {
            block()
        }
    }
}
