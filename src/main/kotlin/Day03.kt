package main.kotlin

fun main() {
    //main.kotlin.example3()
    exercise3()
}

fun exercise3() {
    val map = readStringFileByLine("src/resources/input03.txt")

    listOf(1, 3, 5, 7).forEach { countTrees(map, dimension = 31, steps = it) }

    countTrees(map, dimension = 31, skip = 1)
}

fun example3() {
    val map = listOf(
        "..##.......",
        "#...#...#..",
        ".#....#..#.",
        "..#.#...#.#",
        ".#...##..#.",
        "..#.##.....",
        ".#.#.#....#",
        ".#........#",
        "#.##...#...",
        "#...##....#",
        ".#..#...#.#"
    )

    listOf(1, 3, 5, 7).forEach {

        countTrees(map, dimension = 11, steps = it)
    }

    countTrees(map, dimension = 11, skip = 1)


}

fun countTrees(map: List<String>, dimension: Int = 11, steps: Int = 1, skip: Int = 0): Int {

    var step = 0

    var counter = 0

    var line = 0

    map.forEachIndexed { index, it ->

        if (skip in 1..line) {
            line = 0
            return@forEachIndexed
        }

        val level = it.toCharArray()

        if (level[step % dimension] == '#') {
            counter += 1
        }

        step += steps


        line += 1
    }

    println("counter: $counter")

    return counter
}
