package day07

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day07/test_input")
    check(part1(testInput) == 1)
    check(part2(testInput) == 1)

    val input = readInput("day07/input")
    println(part1(input))
    println(part2(input))
}
