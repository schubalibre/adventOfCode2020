package main.kotlin


class Day10(list:List<Int>) {

    private val window = 2

    private val adapters = list.plus(0).plus(list.maxOrNull()!! + 3).sorted()

    fun solvePart1():Int {
        return adapters
            .windowed(window)
            .groupingBy {
                it[1] - it[0]
            }.eachCount()
            .values.reduce{ acc, it -> acc * it }
    }

    fun solvePart2(): Long {

        val pathsByAdapter: MutableMap<Int,Long> = mutableMapOf(0 to 1L)

        adapters.drop(1).forEach { adapter ->
            pathsByAdapter[adapter] = (1 .. 3).map { lookBack ->
                pathsByAdapter.getOrDefault(adapter - lookBack, 0)
            }.sum()
        }

        return pathsByAdapter.getValue(adapters.last())
    }


}