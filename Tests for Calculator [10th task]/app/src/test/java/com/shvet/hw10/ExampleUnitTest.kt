package com.shvet.hw10

import junit.framework.TestCase.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val parser = ExpressionParser()

    @Test
    fun addTest() {
        val expr = "1.1+2.2"
        val expected = "3.3"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
    fun multiplyTest() {
        val expr = "2X7"
        val expected = "14"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
    fun subtractTest() {
        val expr = "32487-1924"
        val expected = "30563"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
    fun divideTest() {
        val expr = "34987523/2373"
        val expected = "14744.0046354825"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
    fun expTest() {
        val expr = "2^3"
        val expected = "8"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
//    @Throws(Exception::class)
    fun divideByZeroTest() {
        val expr = "10/0"
        val expected = "Infinity"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
    fun doubleDivideTest() {
        val expr = "8.8/2.2"
        val expected = 4.0
        assertEquals(expected, parser.parse(expr).evaluate())
    }

    @Test
    fun doubleExpTest() {
        val expr = "2.1^3.8"
        val expected = "16.7661489457"
        assertEquals(expected, parser.makeStringFromExpression(parser.parse(expr)))
    }

    @Test
    fun doubleMultiplyTest() {
        val expr = "8.8X2.4"
        val expected = 21.12
        assertEquals(expected, parser.parse(expr).evaluate())
    }
}
