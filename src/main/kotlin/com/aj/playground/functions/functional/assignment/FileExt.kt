package com.aj.playground.functions.functional.assignment

import java.io.Closeable
import java.io.File
import java.io.FileOutputStream
import java.nio.charset.Charset

fun File.w(text: String, charset: Charset = Charsets.UTF_8) {
    FileOutputStream(this).process {
        val textBytes = text.toByteArray(charset = charset)
        writeBytes(textBytes)
    }
}

// This is similar to the use() method in kotlin extensions, written for practice
// The issue with this method is, it will throw FileNotFoundException
inline fun <T : Closeable, R> T.process(block: (T) -> R): R {
    var throwable: Throwable? = null
    try {
        return block(this)
    } catch (t: Throwable) { //Throwable is better than catching exception here
        throwable = t
        throw t
    } finally {
        try {
            this.close()
        } catch (t: Throwable) {
            // suppressing
        }
    }
}

