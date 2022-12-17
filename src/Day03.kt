fun main() {
    fun part1(input: List<String>): Int {
        val incorrectSupplies = input.map { line ->
            val l = line.toCharArray().map {
                charToNumber(it)
            }
            val twoBags = Pair(l.subList(0, l.size / 2), l.subList(l.size / 2, l.size))
            findItemInBothLists(twoBags.first, twoBags.second)
        }
        return incorrectSupplies.sum()
    }

    fun part2(input: List<String>): Int {
        return input.devideInGroupsOf3Lines()
            .map { group ->
                group.findUniqueItemInAllLines()
            }.sumOf { item -> charToNumber(item) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}

fun findItemInBothLists(first: List<Int>, second: List<Int>): Int {
    val firstSet = first.toSet()
    val secondSet = second.toSet()
    return firstSet.intersect(secondSet).first()
}

fun charToNumber(it: Char) = when (it.code) {
    in 97..122 -> it.code - 96
    in 65..90 -> it.code - 38
    else -> 0
}

private fun List<String>.findUniqueItemInAllLines(): Char {
    val firstSet = this[0].toSet()
    val secondSet = this[1].toSet()
    val thirdSet = this[2].toSet()
    val intersect = firstSet.intersect(secondSet).intersect(thirdSet)
    return intersect.first()
}

private fun <E> List<E>.devideInGroupsOf3Lines(): List<List<E>> {
    val result = mutableListOf<List<E>>()
    var i = 0
    while (i < this.size) {
        result.add(this.subList(i, i + 3))
        i += 3
    }
    return result
}
