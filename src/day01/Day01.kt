package day01

import readInput

/**
 * --- Day 1: Calorie Counting ---
 */
fun main() {
    fun groupByElf(input: List<String>) = input
        // group calories carried by each elf
        .fold<String, ArrayList<ArrayList<Int>>>(ArrayList()) { acc, s ->
            acc.apply {
                if (isEmpty()) add(arrayListOf())
                if (s.isBlank()) {
                    add(arrayListOf())
                } else {
                    last().add(s.toInt())
                }
            }
        }

    fun part1(input: List<String>): Int = groupByElf(input)
        .maxOf { it.sum() }

    fun part2(input: List<String>): Int = groupByElf(input)
        .map { it.sum() }
        .sortedDescending()
        .take(3)
        .sum()

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/test_input")
    // test part1
    check(part1(testInput) == 24000)
    // test part2
    check(part2(testInput) == 45000)

    val input = readInput("day01/input")
    println(part1(input))
    println(part2(input))
}
