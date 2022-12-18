import java.util.*

data class MoveInstruction(val amount: Int, val from: Int, val to: Int)

fun main() {
    fun parseInput(input: List<String>): Pair<List<Stack<Char>>, List<MoveInstruction>> {
        val stacks = listOf(
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>(),
            Stack<Char>()
        )
        val moveInstructions = mutableListOf<MoveInstruction>()

        input.forEach { line ->
            when {
                line.contains("[") -> {
                    if (line.isNotEmpty() && line[1] != ' ') stacks[0].push(line[1])
                    if (line.length > 3 && line[5] != ' ') stacks[1].push(line[5])
                    if (line.length > 7 && line[9] != ' ') stacks[2].push(line[9])
                    if (line.length > 11 && line[13] != ' ') stacks[3].push(line[13])
                    if (line.length > 15 && line[17] != ' ') stacks[4].push(line[17])
                    if (line.length > 19 && line[21] != ' ') stacks[5].push(line[21])
                    if (line.length > 23 && line[25] != ' ') stacks[6].push(line[25])
                    if (line.length > 27 && line[29] != ' ') stacks[7].push(line[29])
                    if (line.length > 31 && line[33] != ' ') stacks[8].push(line[33])
                }

                line.startsWith("move") -> {
                    val parts = line.split(" ")
                    val amount = parts[1].toInt()
                    val from = parts[3].toInt()
                    val to = parts[5].toInt()
                    moveInstructions.add(MoveInstruction(amount, from, to))
                }
            }
        }

        stacks.map { it.reverse() }

        return Pair(stacks, moveInstructions)
    }

    fun part1(input: List<String>): String {
        val (stacks, moveInstructions) = parseInput(input)

        moveInstructions.forEach { move ->
            val fromStack = stacks[move.from - 1]
            val toStack = stacks[move.to - 1]
            repeat(move.amount) {
                toStack.push(fromStack.pop())
            }
        }

        return stacks.map<Stack<Char>, Any> { it.lastOrNull() ?: "" }.joinToString("")
    }

    fun part2(input: List<String>): String {
        val (stacks, moveInstructions) = parseInput(input)

        moveInstructions.forEach { move ->
            val fromStack = stacks[move.from - 1]
            val toStack = stacks[move.to - 1]

            val moveItems = mutableListOf<Char>()
            repeat(move.amount) {
                moveItems.add(fromStack.pop())
            }

            moveItems.reverse()
            moveItems.forEach { item ->
                toStack.push(item)
            }
        }

        return stacks.map<Stack<Char>, Any> { it.lastOrNull() ?: "" }.joinToString("")
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
