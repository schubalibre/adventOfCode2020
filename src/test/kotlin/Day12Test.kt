package test.kotlin

import main.kotlin.Day12
import main.kotlin.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 12")
class Day122est {

    // Arrange
    private val input = listOf(
        "F10",
        "N3",
        "F7",
        "R90",
        "F11"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day12(input).solvePart1()

            // Assert
            assertEquals(25, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day12(resourceAsList("input12.txt")).solvePart1()

            // Assert
            assertEquals(998, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day12(input).solvePart2()

            // Assert
            assertEquals(286, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day12(resourceAsList("input12.txt")).solvePart2()

            // Assert
            assertEquals(71586, answer)
        }
    }
}