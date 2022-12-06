package day06

import readInput
import kotlin.streams.asSequence

/**
 * --- Day 6: Tuning Trouble ---
 */
fun main() {
    fun part1(input: List<String>): Int {
        val size = 4
        return input.single()
            .windowed(size)
            .indexOfFirst { it.toSet().size == size } + size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day06/test_input")
    check(part1(testInput) == 7)
//    check(part2(testInput) == 1)

    val input = readInput("day06/input")
    println(part1(input))
//    println(part2(input))
}
