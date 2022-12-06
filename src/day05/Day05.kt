package day05

import readInput

/**
 * --- Day 5: Supply Stacks ---
 */
fun main() {
    val p = Regex("\\d+")

    fun parseMoves(input: List<String>): List<List<Int>> {
        return input
            .map { record ->
                p.findAll(record)
                    .map { it.value.toInt() - 1 }
                    .toList()
            }
    }

    fun part1(stacks: List<ArrayDeque<String>>, input: List<String>): String {
        parseMoves(input)
            .map { (n, from, to) ->
                for (i in 0..n) {
                    stacks[from].removeLastOrNull()?.let {
                        stacks[to].addLast(it)
                    }
                }
            }
        return stacks
            .map { it.last() }
            .reduce { acc, c -> acc + c }
    }

    fun part2(stacks: List<ArrayDeque<String>>, input: List<String>): String {
        parseMoves(input)
            .map { (n, from, to) ->
                val fromLast = stacks[from].lastIndex
                stacks[from].subList(fromLast - n, fromLast + 1)
                    .let { stacks[to].addAll(it) }
                for (i in 0..n) {
                    stacks[from].removeLastOrNull()
                }
            }
        return stacks
            .map { it.last() }
            .reduce { acc, c -> acc + c }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day05/test_input")

    /*
    [D]
[N] [C]
[Z] [M] [P]
 1   2   3
     */
    val testStacks = listOf(
        ArrayDeque(listOf("Z", "N")),
        ArrayDeque(listOf("M", "C", "D")),
        ArrayDeque(listOf("P")),
    )
    // stacks are mutable, therefore running one at a time
//    check(part1(testStacks, testInput) == "CMZ")
    check(part2(testStacks, testInput) == "MCD")

    val input = readInput("day05/input")

    /*
        [H]         [S]         [D]
    [S] [C]         [C]     [Q] [L]
    [C] [R] [Z]     [R]     [H] [Z]
    [G] [N] [H] [S] [B]     [R] [F]
[D] [T] [Q] [F] [Q] [Z]     [Z] [N]
[Z] [W] [F] [N] [F] [W] [J] [V] [G]
[T] [R] [B] [C] [L] [P] [F] [L] [H]
[H] [Q] [P] [L] [G] [V] [Z] [D] [B]
 1   2   3   4   5   6   7   8   9
     */
    val stacks = listOf(
        ArrayDeque(listOf("D", "Z", "T", "H").reversed()),
        ArrayDeque(listOf("S", "C", "G", "T", "W", "R", "Q").reversed()),
        ArrayDeque(listOf("H", "C", "R", "N", "Q", "F", "B", "P").reversed()),
        ArrayDeque(listOf("Z", "H", "F", "N", "C", "L").reversed()),
        ArrayDeque(listOf("S", "Q", "F", "L", "G").reversed()),
        ArrayDeque(listOf("S", "C", "R", "B", "Z", "W", "P", "V").reversed()),
        ArrayDeque(listOf("J", "F", "Z").reversed()),
        ArrayDeque(listOf("Q", "H", "R", "Z", "V", "L", "D").reversed()),
        ArrayDeque(listOf("D", "L", "Z", "F", "N", "G", "H", "B").reversed()),
    )
    // stacks are mutable, therefore running one at a time
//    println(part1(stacks, input))
    println(part2(stacks, input))

}
