package com.algolia.search.model.internal

public actual object Time {

    public actual fun getCurrentTimeMillis(): Long {
        return System.currentTimeMillis()
    }
}
