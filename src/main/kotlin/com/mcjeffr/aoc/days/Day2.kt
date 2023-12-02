package com.mcjeffr.aoc.days

import com.mcjeffr.aoc.common.PuzzleInput

fun main() {
    val input = PuzzleInput.getInput(2)
    val games = input.mapIndexed { index, line ->
        Game(
            id = index + 1,
            reds = getCounts(redRegex, line),
            greens = getCounts(greenRegex, line),
            blues = getCounts(blueRegex, line)
        )
    }

    part1(games)
    part2(games)
}

private fun part1(games: List<Game>) {
    val gameIdSum = games
        .filter { game ->
            /* Only the games with bags containing a maximum of 12 reds, 13 greens and 14 blues are possible */
            game.reds.all { it <= 12 } && game.greens.all { it <= 13 } && game.blues.all { it <= 14 }
        }
        .sumOf { it.id }

    println("The sum of the possible game IDs is '$gameIdSum'")
}

private fun part2(games: List<Game>) {
    val gamePowers = games.sumOf { game ->
        game.reds.max() * game.greens.max() * game.blues.max()
    }
    println("The sum of all game powers is '$gamePowers'")
}

private fun getCounts(regex: Regex, line: String): List<Int> = regex.findAll(line)
    .map { match -> match.destructured.component1().toInt() }
    .toList()

data class Game(
    val id: Int,
    val reds: List<Int>,
    val greens: List<Int>,
    val blues: List<Int>
)

private val blueRegex = "(\\d+) blue".toRegex()
private val redRegex = "(\\d+) red".toRegex()
private val greenRegex = "(\\d+) green".toRegex()
