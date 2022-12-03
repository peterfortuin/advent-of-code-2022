fun main() {
    fun findItemInBothLists(first: List<Int>, second: List<Int>): Int {
        val firstSet = first.toSet()
        val secondSet = second.toSet()
        return firstSet.intersect(secondSet).first()
    }

    fun part1(input: List<String>): Int {
        val incorrectSupplies = input.map { line ->
            val l = line.toCharArray().map {
                when (it.code) {
                    in 97..122 -> it.code - 96
                    in 65..90 -> it.code - 38
                    else -> 0
                }
            }
            val twoBags = Pair(l.subList(0, l.size / 2), l.subList(l.size / 2, l.size))
            findItemInBothLists(twoBags.first, twoBags.second)
        }
        return incorrectSupplies.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)

    val input = readInput("Day03")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
