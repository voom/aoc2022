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
            (left..right)
        }
        .sortedBy { it.first }

    fun part1(input: List<String>): Int {
        return input
            .map { toIntRanges(it) }
            .map {
                when {
                    it[0].first < it[1].first
                            && it[0].last >= it[1].last -> 1

                    it[0].first == it[1].first
                            && (it[0].last >= it[1].last || it[1].last > it[0].last) -> 1

                    else -> 0
                }
            }
            .sum()
    }

    fun part2(input: List<String>): Int {
        return input
            .map { toIntRanges(it) }
            .map {
                when {
                    it[0].intersect(it[1]).isNotEmpty() -> 1
                    else -> 0
                }
            }
            .sum()

    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day04/test_input")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("day04/input")
    println(part1(input))
    println(part2(input))
}
