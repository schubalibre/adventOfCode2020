package main.kotlin

import java.io.File
import java.net.URI

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()

internal object Resources {
    fun resourceAsString(fileName: String, delimiter: String = ""): String =
        resourceAsList(fileName).reduce { a, b -> "$a$delimiter$b" }

    fun resourceAsText(fileName: String): String =
        File(fileName.toURI()).readText()

    fun resourceAsList(fileName: String): List<String> =
        File(fileName.toURI()).readLines()

    fun resourceAsListOfInt(fileName: String): List<Int> =
        resourceAsList(fileName).map { it.toInt() }

    fun resourceAsListOfLong(fileName: String): List<Long> =
        resourceAsList(fileName).map { it.toLong() }

    private fun String.toURI(): URI =
        Resources.javaClass.classLoader.getResource(this)?.toURI() ?: throw IllegalArgumentException("Cannot find Resource: $this")
}