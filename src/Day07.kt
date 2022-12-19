fun main() {
    fun parseToTree(input: List<String>): TreeNode {
        val rootNode = TreeNode("root")
        var currentNode = rootNode

        input.forEach { line ->
            when {
                !line.contains("$") && line.contains("dir") -> currentNode.add(TreeNode(line.split(" ")[1]))
                !line.contains("$") -> currentNode.add(TreeNode(line.split(" ")[1], line.split(" ")[0].toInt()))
                line == "$ cd .." -> currentNode = currentNode.parent!!
                line.startsWith("\$ cd ") && line != "\$ cd /" -> currentNode =
                    currentNode.children.first { it.name == line.split(" ")[2] }
            }
        }

        return rootNode
    }

    fun part1(input: List<String>): Int {
        val tree = parseToTree(input)

        var totalSize = 0
        tree.forEachDepthFirst { node ->
            if (node.isDirectory() && node.getSize() < 100000) {
                totalSize += node.getSize()
            }
        }

        return totalSize
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 95437)

    val input = readInput("Day07")
    println("Part 1 = ${part1(input)}")
    println("Part 2 = ${part2(input)}")
}

typealias Visitor = (TreeNode) -> Unit

class TreeNode(val name: String, private val size: Int = 0) {
    val children: MutableList<TreeNode> = mutableListOf()
    var parent: TreeNode? = null

    fun add(child: TreeNode): Boolean {
        child.parent = this
        return children.add(child)
    }

    fun forEachDepthFirst(visit: Visitor) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun getSize(): Int {
        return size + children.sumBy { it.getSize() }
    }

    fun isDirectory(): Boolean {
        return children.isNotEmpty()
    }

    override fun toString(): String {
        return toString(0)
    }

    private fun toString(indentation: Int): String {
        return " ".repeat(indentation) + "- $name\n" + children
            .joinToString("") { child -> child.toString(indentation + 2) }
    }
}
