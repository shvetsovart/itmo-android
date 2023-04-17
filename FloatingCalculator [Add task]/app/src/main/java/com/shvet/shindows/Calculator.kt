package com.shvet.shindows

import android.view.View
import android.widget.Button
import android.widget.TextView

class Calculator(view: View, private var operations: ArrayList<String>) {
    private var workingsTV: TextView = view.findViewById(R.id.workingsTextView)
    private var resultTV: TextView = view.findViewById(R.id.resultTextView)

    private var zeroButton: Button = view.findViewById(R.id.button0)
    private var oneButton: Button = view.findViewById(R.id.button1)
    private var twoButton: Button = view.findViewById(R.id.button2)
    private var threeButton: Button = view.findViewById(R.id.button3)
    private var fourButton: Button = view.findViewById(R.id.button4)
    private var fiveButton: Button = view.findViewById(R.id.button5)
    private var sixButton: Button = view.findViewById(R.id.button6)
    private var sevenButton: Button = view.findViewById(R.id.button7)
    private var eightButton: Button = view.findViewById(R.id.button8)
    private var nineButton: Button = view.findViewById(R.id.button9)

    private var plusButton: Button = view.findViewById(R.id.buttonPlus)
    private var minusButton: Button = view.findViewById(R.id.buttonMinus)
    private var multiplyButton: Button = view.findViewById(R.id.buttonMultiply)
    private var divideButton: Button = view.findViewById(R.id.buttonDivide)
    private var expButton: Button = view.findViewById(R.id.buttonExp)

    private var equalsButton: Button = view.findViewById(R.id.buttonEquals)
    private var clearButton: Button = view.findViewById(R.id.buttonClear)
    private var dotButton: Button = view.findViewById(R.id.buttonDot)

    private var workings: String = ""

    private fun setWorkings(givenValue: String) {
        if ((workings == "0") && (givenValue == "0")) return
        var lastChar = "-"
        if (workings.isNotEmpty()) {
            lastChar = workings[workingsTV.length() - 1].toString()
        }
        if (givenValue != "-" && operations.contains(givenValue) &&
            (workings.isEmpty() || lastChar == givenValue)
        ) return
        workings += givenValue
        workingsTV.text = workings
    }

    init {
        equalsButton.setOnClickListener {
            try {
                val parser = ExpressionParser()
                val stringExpression = parser.makeStringFromExpression(parser.parse(workings))
                resultTV.text = stringExpression
                workingsTV.text = stringExpression
                workings = stringExpression
            } catch (e: Exception) {
                clear()
            }
        }

        clearButton.setOnClickListener {
            clear()
        }

        expButton.setOnClickListener {
            setWorkings("^")
        }

        divideButton.setOnClickListener {
            setWorkings("/")
        }

        sevenButton.setOnClickListener {
            setWorkings("7")
        }

        eightButton.setOnClickListener {
            setWorkings("8")
        }

        nineButton.setOnClickListener {
            setWorkings("9")
        }

        multiplyButton.setOnClickListener {
            setWorkings("X")
        }

        fourButton.setOnClickListener {
            setWorkings("4")
        }

        fiveButton.setOnClickListener {
            setWorkings("5")
        }

        sixButton.setOnClickListener {
            setWorkings("6")
        }

        minusButton.setOnClickListener {
            setWorkings("-")
        }

        oneButton.setOnClickListener {
            setWorkings("1")
        }

        twoButton.setOnClickListener {
            setWorkings("2")
        }

        threeButton.setOnClickListener {
            setWorkings("3")
        }

        plusButton.setOnClickListener {
            setWorkings("+")
        }

        dotButton.setOnClickListener {
            setWorkings(".")
        }

        zeroButton.setOnClickListener {
            setWorkings("0")
        }
    }

    private fun clear() {
        workingsTV.text = ""
        workings = ""
        resultTV.text = ""
    }
}