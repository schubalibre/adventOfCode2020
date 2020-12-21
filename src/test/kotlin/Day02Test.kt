package test.kotlin

import main.kotlin.Day02
import main.kotlin.Resources.resourceAsList
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

@DisplayName("Day 02")
class Day02Test {

    // Arrange
    private val input = listOf(
        "1-3 a: abcde",
        "1-3 b: cdefg",
        "2-9 c: ccccccccc"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day02(input).solvePart1()

            // Assert
            assertEquals(2, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsList("input02.txt")).solvePart1()

            // Assert
            assertEquals(622, answer)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Act
            val answer = Day02(input).solvePart2()

            // Assert
            assertEquals(1, answer)
        }

        @Test
        fun `Actual answer`() {
            // Act
            val answer = Day02(resourceAsList("input02.txt")).solvePart2()

            // Assert
            assertEquals(263, answer)
        }
    }
}