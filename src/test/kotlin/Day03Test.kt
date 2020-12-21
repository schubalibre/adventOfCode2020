package test.kotlin

import main.kotlin.Day03
import main.kotlin.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 03")
class Day03Test {

    // Arrange
    private val input = listOf(
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

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart1()

            // Assert
            assertEquals(7, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsList("input03.txt")).solvePart1()

            // Assert
            assertEquals(191, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day03(input).solvePart2()

            // Assert
            assertEquals(336, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day03(resourceAsList("input03.txt")).solvePart2()

            // Assert
            assertEquals(1478615040, answer)
        }
    }
}