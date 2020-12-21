package test.kotlin

import main.kotlin.Day10
import main.kotlin.Day11
import main.kotlin.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 11")
class Day11Test {

    // Arrange
    private val input = listOf(
        "L.LL.LL.LL",
        "LLLLLLL.LL",
        "L.L.L..L..",
        "LLLL.LL.LL",
        "L.LL.LL.LL",
        "L.LLLLL.LL",
        "..L.L.....",
        "LLLLLLLLLL",
        "L.LLLLLL.L",
        "L.LLLLL.LL"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day11(input).solvePart1()

            // Assert
            assertEquals(37, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsList("input11.txt")).solvePart1()

            // Assert
            assertEquals(2249, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day11(input).solvePart2()

            // Assert
            assertEquals(26, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day11(resourceAsList("input11.txt")).solvePart2()

            // Assert
            assertEquals(2023, answer)
        }
    }
}