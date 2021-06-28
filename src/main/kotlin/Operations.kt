class Operations {

    fun add(number: List<Long>, sum: Long = 0): Long {
        if (number.isNotEmpty()) {
            val addResult = number.reduce { prev, next -> prev + next }
            return sum + addResult
        }
        return 0
    }

    fun divide(numbers: List<Long>, sum: Long = 0): Long {
        if (numbers.isNotEmpty()) {
            val divedResult = numbers.reduce { prev, next ->
                if (next == 0L) {
                    throw ArithmeticException("Division by zero is impossible!")
                } else {
                    prev / next
                }
            }
            return sum + divedResult
        }
        return 0
    }


    fun multiply(numbers: List<Long>, sum: Long = 0): Long {
        if (numbers.isNotEmpty()) {
            val multiplyResult = numbers.reduce { prev, next -> prev * next }
            return sum * multiplyResult
        }
        return 0
    }

    fun subtract(numbers: List<Long>, sum: Long = 0): Long {
        if (numbers.isNotEmpty()) {
            val subtractResult = numbers.reduce { prev, next -> prev - next }
            return sum + subtractResult
        }
        return 0
    }
}