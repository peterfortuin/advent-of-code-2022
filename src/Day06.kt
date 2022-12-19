fun main() {
    fun uniqueValuesFinder(input: String, length: Int): Int {
        var index = length
        input.toCharArray().toList().windowed(length).forEach { possibleStartOfPacketMarker ->
            val pSOPMList = possibleStartOfPacketMarker.toCharArray().toList()
            if (pSOPMList.distinct() == pSOPMList) {
                return index
            }
            index++
        }
        return -1
    }

    fun part1(input: String): Int {
        return uniqueValuesFinder(input, 4)
    }

    fun part2(input: String): Int {
        return uniqueValuesFinder(input, 14)
    }

    // test if implementation meets criteria from the description, like:
    check(part1("bvwbjplbgvbhsrlpgdmjqwftvncz") == 5)
    check(part1("nppdvjthqldpwncqszvftbrmjlhg") == 6)
    check(part1("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 10)
    check(part1("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 11)

    check(part2("mjqjpqmgbljsphdztnvjfqwrcgsmlb") == 19)
    check(part2("bvwbjplbgvbhsrlpgdmjqwftvncz") == 23)
    check(part2("nppdvjthqldpwncqszvftbrmjlhg") == 23)
    check(part2("nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg") == 29)
    check(part2("zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw") == 26)

    val input = readInput("Day06").first()
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}
