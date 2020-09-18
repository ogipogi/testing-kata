package ch.teko.calculator

const val MULTIPLY_SIGN = "*"
const val DIVIDE_SIGN = "/"
const val SPLIT_CHAR = " "

class Calculator {

    fun parse(stmt:String) :Int {
        val (a, op, b) = stmt.split(SPLIT_CHAR)
        return calculate(op, a, b)
    }

    private fun calculate(op: String, a: String, b: String): Int {
        return when (op) {
            MULTIPLY_SIGN -> a.toInt() * b.toInt()
            DIVIDE_SIGN -> a.toInt() / b.toInt()
            else -> throw IllegalArgumentException()
        }
    }

}