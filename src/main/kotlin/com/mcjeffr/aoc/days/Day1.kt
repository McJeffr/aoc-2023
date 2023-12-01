package com.mcjeffr.aoc.days

import com.mcjeffr.aoc.common.PuzzleInput

fun main() {
    val input = PuzzleInput.getInput(1)
    part1(input)
    part2(input)
}

fun part1(input: List<String>) {
    val sum = input.sumOf { line ->
        val leftDigit = line.first { it.isDigit() }
        val rightDigit = line.last { it.isDigit() }
        "$leftDigit$rightDigit".toInt()
    }
    println("The sum of the lines of text is '$sum'")
}

fun part2(input: List<String>) {

}
