package day06

import readInput

/**
 * --- Day 6: Tuning Trouble ---
 */
fun main() {
    fun findIndexOfStart(input: String, size: Int) = input
        .windowed(size)
        .indexOfFirst { it.toSet().size == size } + size

    fun part1(input: List<String>): Int {
        return findIndexOfStart(input.single(), 4)
    }

    fun part2(input: List<String>): Int {
        return findIndexOfStart(input.single(), 14)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06/test_input")
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInput("day06/input")
    println(part1(input))
    println(part2(input))
}
