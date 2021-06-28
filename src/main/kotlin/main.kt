import conts.CalculatorConstant
import exception.NotNumberException

private var isExit: Boolean = false
private var sum: Long = 0
fun main(args: Array<String>) {
    showOperation()
    readOperation()
}

private fun readOperation() {
    println("Chose operation")
    val operation: Int? = readLine()?.toIntOrNull()
    checkOperation(operation)
}

private fun nextValue(): Boolean {
    println("Enter next value Yes/No")
    val line = readLine()
    if (line == "yes" || line == "Yes" || line == "y" || line == "Y") {
        return true
    }
    isExit = true
    return false
}

private fun readNumber(): Long {
    println("Enter a number")
    val number: String? = readLine();
    if (!number.isNullOrBlank()) {
        val numberAsLong = number.toLongOrNull();
        if (numberAsLong != null) {
            return numberAsLong
        }
    }
    throw NotNumberException("Read value not a number")
}

private fun showOperation() {
    CalculatorConstant.values().forEachIndexed { index, calculatorConstant ->
        println("$index) $calculatorConstant")
    }
}

private fun checkOperation(operation: Int?) {
    if (operation != null) {
        val operations = Operations()
        when (operation) {
            0 -> {
                isExit = false
                sum = operations.add(getNumbers(), sum)
            }
            1 -> {
                isExit = false
                sum = operations.subtract(getNumbers(), sum)
            }
            2 -> {
                isExit = false
                sum = operations.multiply(getNumbers(), sum)
            }
            3 -> {
                isExit = false
                sum = operations.divide(getNumbers(), sum)
            }
            4 -> {
                sum = 0
                print("============Cleaned============")
            }
        }
        println(sum)
        showOperation()
        readOperation()
    } else {
        throw NotNumberException("Entered operation $operation not a number")
    }
}

private fun getNumbers(): ArrayList<Long> {
    val numbers: ArrayList<Long> = arrayListOf();
    while (!isExit) {
        if (nextValue()) {
            val number = readNumber();
            numbers.add(number)
        }
    }
    return numbers;
}