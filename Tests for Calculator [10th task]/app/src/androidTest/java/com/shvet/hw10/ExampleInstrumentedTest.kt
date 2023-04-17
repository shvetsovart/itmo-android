package com.shvet.hw10

import android.content.pm.ActivityInfo
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun displaysNumberOnClick() {
        press(R.id.button7)
        matchesResult("7")
    }

    @Test
    fun keepsSingleLeadingZero() {
        repeat(3) {
            press(R.id.button0)
        }
        matchesResult("0")
    }

    @Test
    fun allowsTrailingZeroes() {
        press(R.id.button0)
        press(R.id.buttonDot)
        repeat(3) {
            press(R.id.button0)
        }
        matchesResult("0.000")
    }

    @Test
    fun clearsResultField() {
        repeat(3) {
            press(R.id.button9)
        }
        press(R.id.buttonC)
        matchesResult("")
    }

    @Test
    fun keepsSingleOperationSymbol() {
        press(R.id.button8)
        repeat(3) {
            press(R.id.buttonDivide)
        }
        matchesResult("8/")
    }

    @Test
    fun calculatesOnClick() {
        press(R.id.button7)
        press(R.id.buttonMultiply)
        press(R.id.button3)
        press(R.id.buttonPlus)
        press(R.id.button6)
        press(R.id.buttonMinus)
        press(R.id.button2)
        press(R.id.button2)
        press(R.id.buttonEquals)
        matchesResult("5")
    }

    @Test
    fun ignoresOperationWithoutArguments() {
        repeat(4) {
            press(R.id.buttonExp)
        }
        matchesResult("")
    }

    @Test
    fun handlesUnaryMinus() {
        repeat(5) {
            press(R.id.buttonMinus)
        }
        press(R.id.button4)
        matchesResult("-----4")
    }


    @Test
    fun resultSurvivesRotation() {
        press(R.id.button1)
        press(R.id.buttonPlus)
        tilt()
        press(R.id.button5)
        straighten()
        press(R.id.buttonEquals)
        matchesResult("6")
    }

    private fun press(viewId: Int) = onView(withId(viewId)).perform(click())

    private fun tilt() {
        activityRule.scenario.onActivity {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_LANDSCAPE
        }
    }

    private fun straighten() {
        activityRule.scenario.onActivity {
            it.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER_PORTRAIT
        }
    }

    private fun matchesResult(expected: String) =
        onView(withId(R.id.workingsTextView)).check(matches(withText(expected)))
}