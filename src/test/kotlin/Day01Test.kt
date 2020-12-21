package test.kotlin

import main.kotlin.Day01
import main.kotlin.Day10
import main.kotlin.Resources.resourceAsListOfInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 10")
class Day01Test {

    // Arrange
    private val input = listOf(1721, 979, 366, 299, 675, 1456)

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).solvePart1()

            // Assert
            assertEquals(514579,answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfInt("input01.txt")).solvePart1()

            // Assert
            assertEquals(55776,answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day01(input).solvePart2()

            // Assert
            assertEquals(241861950,answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day01(resourceAsListOfInt("input01.txt")).solvePart2()

            // Assert
            assertEquals(223162626,answer)
        }
    }
}