fun main() {
    fun part1(input: List<String>): Int {
        val elfs = input.asElfs()
        val caloriesPerElf = elfs.map { elfCaloriesList ->
            elfCaloriesList.map { calories ->
                calories.toInt()
            }.toIntArray().sum()
        }

        val highestCaloryElf = caloriesPerElf.foldIndexed(Pair<Int, Int>(0, 0)) { index, acc, elfCalories ->
            if (elfCalories > acc.second) {
                Pair(index, elfCalories)
            } else {
                acc
            }
        }

        return highestCaloryElf.second
    }

    fun part2(input: List<String>): Int {
        val elfs = input.asElfs()
        val caloriesPerElf = elfs.map { elfCaloriesList ->
            elfCaloriesList.map { calories ->
                calories.toInt()
            }.toIntArray().sum()
        }

        val top3Elfs = caloriesPerElf.sortedDescending().subList(0, 3)
        val totalOfTop3 = top3Elfs.sum()

        return totalOfTop3
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}

fun List<String>.asElfs(): List<List<String>> {
    val elfList = mutableListOf<MutableList<String>>()
    elfList.add(mutableListOf())

    return this.fold(elfList) { acc, line ->
        if (line.isBlank()) {
            elfList.add(mutableListOf())
        } else {
            elfList.last().add(line)
        }
        acc
    }
}
