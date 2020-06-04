package com.algolia.search.model

import platform.Foundation.NSDate
import platform.Foundation.timeIntervalSince1970

internal actual object Time {
    actual fun getCurrentTimeMillis(): Long {
        return (NSDate().timeIntervalSince1970 * 1000).toLong()
    }
}
