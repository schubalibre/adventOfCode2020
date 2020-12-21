package main.kotlin


class Day01(list: List<Int>) {

    private val expenses = list.sorted()

    fun solvePart1(): Int {

        val entries = find2020Pair(expenses.tail, expenses.head)

        return entries.first * entries.second
    }

    fun solvePart2(): Int {
        val triple = find2020Triple(expenses.tail, expenses.head)

        return triple.first * triple.second * triple.third
    }


    private fun find2020Pair(expenses: List<Int>, head: Int): Pair<Int, Int> {

        val entity = expenses.find { head + it == 2020 }

        entity?.let {
            return Pair(head, entity)
        }


        return find2020Pair(expenses.tail, expenses.head)

    }

    private fun find2020Triple(expenses: List<Int>, head: Int): Triple<Int, Int, Int> {

        val entity: Triple<Int, Int, Int>? = expenses.map { head2 ->
            val entity = expenses.find { it != head2 && head + head2 + it == 2020 }
            entity?.let {
                return Triple(head, head2, entity)
            }
        }.firstOrNull()


        entity?.let { it ->
            return it
        }

        return find2020Triple(
            expenses.tail,
            expenses.head
        )
    }
}



