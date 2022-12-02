fun main() {
    fun part1(input: List<String>): Int {
        return input.map { rps ->
            when (rps) {
                "A X" -> 3 + 1// Rock rock
                "A Y" -> 6 + 2// Rock paper
                "A Z" -> 0 + 3// Rock scissors

                "B X" -> 0 + 1// Paper rock
                "B Y" -> 3 + 2// Paper paper
                "B Z" -> 6 + 3// Paper scissors

                "C X" -> 6 + 1// Scissors rock
                "C Y" -> 0 + 2// Scissors paper
                "C Z" -> 3 + 3// Scissors scissors

                else -> 0
            }
        }.sum()
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)

    val input = readInput("Day02")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
