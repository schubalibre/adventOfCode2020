import java.lang.Exception
import java.lang.RuntimeException
import kotlin.Pair
import kotlin.test.assertEquals

fun main() {

    example()

    exercise()

}

fun example() {
    val expenses = listOf<Int>(1721, 979, 366, 299, 675, 1456)

    val entries = find2020Pair(expenses.tail, expenses.head)

    assertEquals(Pair(1721,299), entries)

    println("example: " + entries.first * entries.second)


    val triple = find2020Triple(expenses.tail, expenses.head)

    assertEquals(Triple(979,366,675), triple)

    println("example: " + triple.first * triple.second * triple.third)


}

fun exercise() {

    val expenses = readIntFileByLine("src/resources/input01.txt")

    val entries = find2020Pair(expenses.tail, expenses.head)

    println("exercise: " + entries.first * entries.second)

    val triple = find2020Triple(expenses.tail, expenses.head)

    println("example: " + triple.first * triple.second * triple.third)
}

fun find2020Pair(expenses: List<Int>, head: Int): Pair<Int,Int> {

     val entity = expenses.find{ head + it == 2020}

    entity?.let {
        return Pair(head, entity)
    }


    return find2020Pair(expenses.tail, expenses.head)

}

fun find2020Triple(expenses: List<Int>, head: Int): Triple<Int,Int,Int> {

    val entity: Triple<Int,Int,Int>? = expenses.map { head2 ->
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
