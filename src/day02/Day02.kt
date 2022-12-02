package day02

import readInput

fun main() {
    /*
    The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors.
    The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors.

    The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
    plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
     */
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day02/test_input")
    check(part1(testInput) == 15)
//    check(part2(testInput) == 1)

    val input = readInput("day02/input")
    println(part1(input))
//    println(part2(input))
}
