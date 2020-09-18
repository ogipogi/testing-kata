package ch.teko.calculator

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class CalculatorTest {

    /*
    2 * 2 -> 4
     */
    @ParameterizedTest
    @CsvSource(
            "2 * 2, 4",
            "9 * 9, 81",
            "5 * 7, 35",
            "15 * 0, 0",
            "-2 * -2, 4"
    )
    fun `should multiply values`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.parse(input)

        // then
        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
            "2 / 2, 1",
            "81 / 9, 9",
            "49 / 7, 7",
            "90 / 15, 6",
            "-100 / -10, 10"
    )
    fun `should divide values`(input: String, expected: Int) {
        // given
        val calculator = Calculator()

        // when
        val result = calculator.parse(input)

        // then
        Assertions.assertEquals(expected, result)
    }

    @Test
    fun `should throw ArithmeticException when divide 0`() {
        // given
        val calculator = Calculator()

        //when
        assertThrows(ArithmeticException::class.java) {
            calculator.parse("10 / 0")
        }
    }

    @ParameterizedTest
    @CsvSource(
            "10 + 5",
            "81 - 9",
            "49 % 7",
            "90 ! 15"
    )
    fun `should throw IllegalArgumentException when operator is not multiply or divide`(input: String) {
        // given
        val calculator = Calculator()

        //when
        assertThrows(IllegalArgumentException::class.java) {
            calculator.parse(input)
        }
    }

}