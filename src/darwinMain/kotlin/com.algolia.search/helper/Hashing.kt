package com.algolia.search.helper

import io.ktor.util.InternalAPI
import io.ktor.util.encodeBase64
import kotlinx.cinterop.addressOf
import kotlinx.cinterop.convert
import kotlinx.cinterop.usePinned
import platform.CoreCrypto.CCHmac
import platform.CoreCrypto.CC_SHA256_DIGEST_LENGTH
import platform.CoreCrypto.kCCHmacAlgSHA256
import platform.Foundation.NSData
import platform.Foundation.NSUTF8StringEncoding
import platform.Foundation.base64Encoding
import platform.Foundation.create

@OptIn(ExperimentalUnsignedTypes::class, InternalAPI::class)
internal actual fun String.sha256(key: String): String {
    val digest = hmac256Encode(key.encodeToByteArray(), this)
    println(digest.encodeBase64())
    return digest.toHex(true)
}

@ExperimentalUnsignedTypes
private fun hmac256Encode(key: ByteArray, value: String): ByteArray {
    val input = value.encodeToByteArray()
    val digest = UByteArray(CC_SHA256_DIGEST_LENGTH)
    key.usePinned { keyPinned ->
        input.usePinned { inputPinned ->
            digest.usePinned { digestPinned ->
                CCHmac(
                    algorithm = kCCHmacAlgSHA256,
                    key = keyPinned.addressOf(0),
                    keyLength = key.size.convert(),
                    data = inputPinned.addressOf(0),
                    dataLength = input.size.convert(),
                    macOut = digestPinned.addressOf(0)
                )
            }
        }
    }
    return digest.toByteArray()
}

internal actual fun String.encodeBase64(): String {
    val data = NSData.create(base64EncodedString = this, options = NSUTF8StringEncoding)!!
    return data.base64Encoding()
}

internal actual fun String.decodeBase64(): String {
    // TODO("Not yet implemented")
    return this
}
