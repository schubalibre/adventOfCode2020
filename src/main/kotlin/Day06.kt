package main.kotlin

fun main() {
    //main.kotlin.example6()
    exercise6()
}

fun exercise6() {
    val answers = readStringFileByLine("src/resources/input06.txt")
    //println(main.kotlin.countAnswers(answers))
    println(countSameAnswersEachGroup(answers))
}

fun example6() {
    val answers = listOf(
        "abc",
        "",
        "a",
        "b",
        "c",
        "",
        "ab",
        "ac",
        "",
        "a",
        "a",
        "a",
        "a",
        "",
        "b"
    )

    //println(main.kotlin.countAnswers(answers))
    println(countSameAnswersEachGroup(answers))

}

private fun countAnswers(answers: List<String>): Int {
    return answers
        .joinToString(" ") { if (it == "") "|" else it }
        .split("|").toTypedArray()
        .map { it ->
            it
                .toCharArray()
                .distinct()
                .filter { !it.isWhitespace() }
                .distinct()
                .count()
        }.sum()
}

private fun countSameAnswersEachGroup(answers: List<String>): Int {
    return answers
        .joinToString(" ") { if (it == "") "|" else it }
        .split("|").toTypedArray()
        .map { it ->
            val a = it
                .trim()
                .split(" ").toTypedArray()
                .map {
                    it.toCharArray()
                }

            if (a.size == 1) {
                a.first().distinct().size
            } else {
                a.flatMap { it.toList() }.groupingBy { it }
                    .eachCount()
                    .filter { it.value >= a.size }
                    .size
            }
        }.sum()
}
