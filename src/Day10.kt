fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 1)

    val input = readInput("Day10")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
