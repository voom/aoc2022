package day03

import readInput

/**
 * --- Day 3: Rucksack Reorganization ---
 */
fun main() {
    fun defineType(p1: String, p2: String): Char {
        return p1.first { p2.contains(it) }
    }

    fun calcPrio(it: Char) = if (it.isLowerCase()) it - 'a' + 1 else it - 'A' + 27

    /**
     * Sum priorities of rucksack content item types
     */
    fun part1(input: List<String>): Int {
        return input
            .map {
                val mid = it.length / 2
                it.substring(0, mid) to it.substring(mid)
            }
            .map { (p1, p2) ->
                defineType(p1, p2)
            }.sumOf { calcPrio(it) }
    }

    fun defineBadge(g1: String, g2: String, g3: String): Char {
        return g1.first { g2.contains(it) && g3.contains(it) }
    }

    /**
     * Sum priorities of group's badge item types
     */
    fun part2(input: List<String>): Int {
        return input
            .chunked(3)
            .map {
                defineBadge(it[0], it[1], it[2])
            }
            .sumOf { calcPrio(it) }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day03/test_input")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("day03/input")
    println(part1(input))
    println(part2(input))
}
