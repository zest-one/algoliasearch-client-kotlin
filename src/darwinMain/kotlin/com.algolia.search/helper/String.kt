package com.algolia.search.helper

import com.algolia.search.extension.asNSString
import platform.Foundation.NSMutableCharacterSet
import platform.Foundation.stringByAddingPercentEncodingWithAllowedCharacters

actual fun String.encodeUTF8(): String {
    val unreserved = "*-._ "
    val allowed = NSMutableCharacterSet.alphanumericCharacterSet()
    allowed.addCharactersInString(unreserved)
    val encoded = asNSString().stringByAddingPercentEncodingWithAllowedCharacters(allowed)!!
    return encoded.replace(' ', '+')
}
