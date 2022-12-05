package day04

import readInput

/**
 * --- Day 4: Camp Cleanup ---
 */
fun main() {
    fun toIntRanges(sections: String) = sections.split(',')
        .map { range ->
            val (left, right) = range
                .split('-')
                .map { it.toInt() }
            (left..right).toSet()
        }

    fun part1(input: List<String>): Int {
        return input
            .map { toIntRanges(it) }
            .let {
                it.count { (a, b) ->
                    a.containsAll(b) || b.containsAll(a)
                }
            }
    }

    fun part2(input: List<String>): Int {
        return input
            .map { toIntRanges(it) }
            .let {
                it.count { (a, b) ->
                    a.intersect(b).isNotEmpty()
                }
            }

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/test_input")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day04/input")
    println(part1(input))
    println(part2(input))
}
