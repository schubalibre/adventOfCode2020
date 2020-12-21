package main.kotlin


class Day03(list: List<String>) {

    private val lines = list.map { it.toCharArray() }

    private val width = lines.head.size
    private val height = lines.size - 1

    private val slope = Pair(3, 1)

    private val allSlopes = listOf(
        Pair(1, 1), Pair(3, 1), Pair(5, 1), Pair(7, 1), Pair(1, 2)
    )

    private fun traverse(a: Int, b: Int) = (0..height / b)
        .count { i ->
            lines[i * b][(a * i) % width] == '#'
        }

    fun solvePart1() = traverse(slope.first, slope.second)


    fun solvePart2() = allSlopes.map{
        traverse(it.first, it.second)
    }.reduce { acc, i -> acc * i }

}


