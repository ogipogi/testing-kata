package ch.teko.fizzbuzz

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

/*
1
2
Fizz
4
Buzz
Fizz
7
8
Fizz
Buzz
11
Fizz
13
14
FizzBuzz
16
17
35
 */

class FizzBuzzTest {

    @ParameterizedTest
    @CsvSource(
            "3, Fizz",
            "6, Fizz",
            "9, Fizz",
            "33, Fizz"
    )

    internal fun `should print Fizz for number dividable by 3`(input:Int, expected:String) {

        // given++++
        val fizzBuzz = FizzBuzz()

        // when
        val result = fizzBuzz.analyzeNumber(input)

        // then
        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
            "1",
            "2",
            "4",
            "34"
    )
    internal fun `should print the same number for number not dividable by 3`(input:Int) {
        // given
        val fizzBuzz = FizzBuzz()

        // when
        val result = fizzBuzz.analyzeNumber(input)

        // then
        Assertions.assertEquals(input.toString(), result)
    }

    @ParameterizedTest
    @CsvSource(
            "5, Buzz",
            "20, Buzz",
            "25, Buzz"
    )
    internal fun `should print Buzz for number dividable by 5`(input:Int, expected:String) {
        // given
        val fizzBuzz = FizzBuzz()

        // when
        val result = fizzBuzz.analyzeNumber(input)

        // then
        Assertions.assertEquals(expected, result)
    }

    @ParameterizedTest
    @CsvSource(
            "15, FizzBuzz",
            "30, FizzBuzz",
            "45, FizzBuzz"
    )
    internal fun `should print Buzz for number dividable by 3 and 5`(input:Int, expected:String) {
        // given
        val fizzBuzz = FizzBuzz()

        // when
        val result = fizzBuzz.analyzeNumber(input)

        // then
        Assertions.assertEquals(expected, result)
    }
}