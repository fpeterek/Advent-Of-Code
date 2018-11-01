
fun redistribute(banks: MutableList<Int>) {

    val max = banks.max()!!
    var index = banks.indexOf(max)
    var blocksToAlloc = max

    banks[index] = 0

    while (blocksToAlloc > 0) {

        ++index

        if (index >= banks.size) {
            index = 0
        }

        ++banks[index]
        --blocksToAlloc

    }

}

fun main(args: Array<String>) {

    val input = "5 1 10 0 1 7 13 14 3 12 8 10 7 12 0 6"

    val banks = input.split(" ").map { it.toInt() }.toMutableList()

    val occuredCombinations = mutableListOf<String>()

    while (true) {
        redistribute(banks)
        val combination = banks.fold("") { acc: String, i: Int -> "$acc$i " }

        if (occuredCombinations.find {it == combination} != null) {
            break
        }

        occuredCombinations.add(combination)

    }

    println(occuredCombinations.size + 1)

}
