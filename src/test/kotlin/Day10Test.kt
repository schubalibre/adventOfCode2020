package test.kotlin

import main.kotlin.Day10
import main.kotlin.Resources.resourceAsListOfInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
class Day10Test {

    // Arrange
    private val input = listOf(16, 10, 15, 5, 1, 11, 7, 19, 6, 12, 4)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day10(input).solvePart1()

            // Assert
            assertEquals(35,answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfInt("input10.txt")).solvePart1()

            // Assert
            assertEquals(2059,answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day10(input).solvePart2()

            // Assert
            assertEquals(8,answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day10(resourceAsListOfInt("input10.txt")).solvePart2()

            // Assert
            assertEquals(86812553324672L,answer)
        }
    }
}