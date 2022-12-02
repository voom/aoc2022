package day02

import day02.Move.*
import day02.RoundResult.*
import readInput

fun main() {
    val choiceScore = mapOf(
        ROCK to 1,
        PAPER to 2,
        SCISSORS to 3
    )

    fun calcRoundScore(pair: Pair<Move, Move>): Int {
        val comparator = ResultComparator()
        val result: RoundResult = when (comparator.compare(pair.first, pair.second)) {
            -1 -> LOST
            0 -> DRAW
            1 -> WIN
            else -> throw IllegalArgumentException("Unknown result")
        }
        return result.score + choiceScore[pair.second]!!
    }

    fun parseMove(code: String): Move {
        return when (code) {
            "A", "X" -> ROCK
            "B", "Y" -> PAPER
            "C", "Z" -> SCISSORS
            else -> throw IllegalArgumentException("Unknown code $code")
        }
    }

    /*
            The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors.
            The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors.

            The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
            plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
             */
    fun part1(input: List<String>): Int {
        return input
            .map {
                val (o1, o2) = it.split(" ")
                Pair(parseMove(o1), parseMove(o2))
            }
//            .also { println(it) }
            .map { calcRoundScore(it) }
//            .also { println(it) }
            .sum()
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

enum class RoundResult(val score: Int) {
    LOST(0),
    DRAW(3),
    WIN(6)
}

enum class Move {
    ROCK,
    PAPER,
    SCISSORS
}

class ResultComparator : Comparator<Move> {
    override fun compare(op: Move, my: Move): Int {
        return when {
            op == my -> 0
            (op == ROCK && my == PAPER)
                    || (op == PAPER && my == SCISSORS)
                    || (op == SCISSORS && my == ROCK) -> 1

            else -> -1
        }
    }

}
