package main.kotlin

import java.lang.IllegalArgumentException
import kotlin.math.abs


class Day12(list: List<String>) {

    data class Vec(val x: Int, val y: Int) {
        operator fun plus(that: Vec): Vec = Vec(x + that.x, y + that.y)
        operator fun times(v: Int): Vec = Vec(x * v, y * v)
        fun rotate(v: Int): Vec = if (v > 0) Vec(-y, x).rotate(v - 1) else this
        val manhattan: Int = abs(x) + abs(y)
    }

    interface Action

    data class Cardinal(val direction: Vec) : Action
    data class Rotation(val amount: Int) : Action
    data class Forward(val steps: Int) : Action

    private val Zero = Vec(0, 0)
    private val angle = 90


    private val orders: List<Action> = list.map {
        val order: String = it.filter { l -> l.isLetter() }
        val units: Int = it.filter { n -> n.isDigit() }.toInt()
        Pair(order, units)
    }.map {
        when (it.first) {
            "N" -> Cardinal(Vec(0, it.second))
            "S" -> Cardinal(Vec(0, -it.second))
            "E" -> Cardinal(Vec(it.second, 0))
            "W" -> Cardinal(Vec(-it.second, 0))
            "L" -> Rotation(it.second / angle)
            "R" -> Rotation(4 - it.second / angle)
            "F" -> Forward(it.second)
            else -> throw IllegalArgumentException()
        }
    }

    fun solvePart1() = orders.fold(Pair(Zero, Vec(1,0))) { acc, action ->

        val position = acc.first
        val waypoint = acc.second

        when(action) {
            is Cardinal -> Pair(position + action.direction, waypoint)
            is Rotation -> Pair(position, waypoint.rotate(action.amount))
            is Forward -> Pair(position + waypoint * action.steps, waypoint)
            else -> throw IllegalArgumentException()
        }
    }.first.manhattan

    fun solvePart2() = orders.fold(Pair(Zero, Vec(10,1))) { acc, action ->

        val position = acc.first
        val waypoint = acc.second

        when(action) {
            is Cardinal -> Pair(position, waypoint + action.direction)
            is Rotation -> Pair(position, waypoint.rotate(action.amount))
            is Forward -> Pair(position + waypoint * action.steps, waypoint)
            else -> throw IllegalArgumentException()
        }
    }.first.manhattan


}