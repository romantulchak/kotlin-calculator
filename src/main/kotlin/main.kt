import conts.CalculatorConstant
import exception.NotNumberException

private var isExit: Boolean = false

fun main(args: Array<String>) {
    showOperation()
    readOperation()
}

private fun readOperation(){
    println("Chose operation")
    val operation:Int? = readLine()?.toIntOrNull()
    checkOperation(operation)
}
private fun readNumber():Long{
    println("Enter a number or write Exit")
    val number:String? = readLine();
    if(!number.isNullOrBlank()) {
        if(number == "Exit"){
            isExit = true;
            return 0
        }
        val numberAsLong = number.toLongOrNull();
        if(numberAsLong != null){
            return numberAsLong
        }
    }
    throw NotNumberException("Read value not a number")
}
private fun showOperation(){
    CalculatorConstant.values().forEachIndexed {index, calculatorConstant ->
        println("$index) $calculatorConstant")
    }
}

private fun checkOperation(operation: Int?){
    if(operation != null){
        val operations = Operations()
        var sum: Long = 0
        when (operation) {
            0 -> {
                isExit = false
                sum += operations.add(getNumbers())
            }
        }
        println(sum)
    }else{
        throw NotNumberException("Entered operation $operation not a number")
    }
}

private fun getNumbers():ArrayList<Long>{
    val numbers: ArrayList<Long> = arrayListOf();
    while (!isExit) {
        numbers.add(readNumber())
    }
    return numbers;
}