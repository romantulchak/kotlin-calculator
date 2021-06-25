class Operations{

    fun add(number: List<Long>): Long{
        if (number.isNotEmpty()) {
            var sum: Long = 0
            number.forEach { it ->
                sum += it
            }
            return sum
        }
        return 0
    }

    fun divide(): Long{
        return 0
    }

    fun multiply():Long{
        return 0
    }

    fun subtract(): Long{
        return 0
    }


}