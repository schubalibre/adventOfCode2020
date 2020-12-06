import java.io.File

val <T> List<T>.tail: List<T>
    get() = drop(1)

val <T> List<T>.head: T
    get() = first()


fun readIntFileByLine(fileName: String): List<Int> = File(fileName)
    .readLines()
    .map { it.toInt()}

fun readStringFileByLine(fileName: String): List<String> = File(fileName)
    .readLines()