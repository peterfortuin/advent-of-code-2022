fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { line ->
                line.parseLine()
            }.map { rangePair ->
                when {
                    rangePair.first.intersect(rangePair.second) == rangePair.second.toSet() -> 1
                    rangePair.second.intersect(rangePair.first) == rangePair.first.toSet() -> 1
                    else -> 0
                }
            }.sum()
    }

    fun part2(input: List<String>): Int {
        return input
            .map { line ->
                line.parseLine()
            }.map { rangePair ->
                when {
                    rangePair.first.intersect(rangePair.second).isNotEmpty() -> 1
                    rangePair.second.intersect(rangePair.first).isNotEmpty() -> 1
                    else -> 0
                }
            }.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}

private fun String.parseLine(): Pair<IntRange, IntRange> {
    val parts = this.split(",")
    val firstRange = parts[0].toRange()
    val secondRange = parts[1].toRange()

    return Pair(firstRange, secondRange)
}

private fun String.toRange(): IntRange {
    val parts = this.split("-")
    return IntRange(parts[0].toInt(), parts[1].toInt())
}
