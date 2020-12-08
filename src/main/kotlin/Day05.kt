package main.kotlin

import kotlin.math.floor
import kotlin.test.assertEquals

fun main() {
    //main.kotlin.example5()
    exercise5()
}

fun exercise5() {
    val bsps = readStringFileByLine("src/resources/input05.txt")
    getMaxId(calcSeatIds(bsps))

    val filtered = calcSeatIds(bsps).sortedWith(compareBy({ it.first }, { it.second }))

    filtered
        .groupBy { it.first }
        .filter {
            it.value.size != 8
        }.forEach {
            println(it)
        }

    //println(a)

}


fun example5() {
    val bsps = listOf(
        "FBFBBFFRLR",
        "BFFFBBFRRR",
        "FFFBBBFRRR",
        "BBFFBBFRLL"
    )

    getMaxId(calcSeatIds(bsps))
    val filtered = calcSeatIds(bsps).sortedWith(compareBy({ it.first }, { it.second }))

    filtered.forEach { seats ->
        (0..7).forEach {
            if (it.toDouble() != seats.second) {
                print(seats)
            }
        }
    }
}

fun getMaxId(calcSeatIds: List<Pair<Double, Double>>) {
    val ids = calcSeatIds.map { it.first * 8 + it.second }
    println(ids.maxOrNull())
}

fun calcSeatIds(bsps: List<String>): List<Pair<Double, Double>> {

    return bsps.map {
        val row = Pair(0.0, 127.0)
        val seat = Pair(0.0, 7.0)

        val bsp = it.toCharArray()

        val rowCoordinate = bsp.take(7)
        val seatCoordinate = bsp.takeLast(3)

        val myRow = findRow(rowCoordinate, row)
        val mySeat = findSeat(seatCoordinate, seat)

        Pair(myRow, mySeat)
    }
}

fun findSeat(seatCoordinate: List<Char>, seat: Pair<Double, Double>): Double {
    val mySeat = findPlace(seatCoordinate, seat, 'L')
    assertEquals(mySeat.first, mySeat.second)
    return mySeat.first
}

fun findRow(rowCoordinate: List<Char>, row: Pair<Double, Double>): Double {
    val myRow = findPlace(rowCoordinate, row, 'F')
    assertEquals(myRow.first, myRow.second)
    return myRow.first
}

private fun findPlace(
    coordinate: List<Char>,
    point: Pair<Double, Double>,
    lower: Char
): Pair<Double, Double> {
    if (coordinate.isEmpty()) return point

    val letter = coordinate.head

    val newPoint = if (letter == lower) {
        Pair(point.first, floor(point.second - (point.second - point.first) / 2))
    } else {
        Pair(kotlin.math.ceil(point.first + (point.second - point.first) / 2), point.second)
    }

    //println(letter)
    //println(newPoint)

    return findPlace(coordinate.tail, newPoint, lower)
}
