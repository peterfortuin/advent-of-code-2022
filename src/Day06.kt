fun main() {
    fun part1(input: List<String>): Int {
        val inputLine = input.first()
        var index = 4
        inputLine.toCharArray().toList().windowed(4).forEach { possibleStartOfPacketMarker ->
            val pSOPMList = possibleStartOfPacketMarker.toCharArray().toList()
            if (pSOPMList.distinct() == pSOPMList) {
                return index
            }
            index++
        }
        return -1
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day06_test")
    check(part1(testInput) == 5)

    val input = readInput("Day06")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
