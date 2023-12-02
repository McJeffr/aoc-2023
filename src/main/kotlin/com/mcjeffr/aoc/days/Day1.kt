package com.mcjeffr.aoc.days

import com.mcjeffr.aoc.common.PuzzleInput

fun main() {
    val input = PuzzleInput.getInput(1)
    part1(input)
    part2(input)
}

private fun part1(input: List<String>) {
    val sum = input.sumOf { line ->
        val leftDigit = line.first { it.isDigit() }
        val rightDigit = line.last { it.isDigit() }
        "$leftDigit$rightDigit".toInt()
    }
    println("The sum of the lines of text is '$sum'")
}

private fun part2(input: List<String>) {
    val sum = input.sumOf { line ->
        val leftDigit = line.findFirst(numbersList)?.toDigit()
        val rightDigit = line.findLast(numbersList)?.toDigit()
        "$leftDigit$rightDigit".toInt()
    }
    println("The sum of the lines of text is '$sum'")
}

private fun String.findFirst(strings: List<String>): String? {
    var index: Int = Int.MAX_VALUE
    var match: String? = null
    strings.forEach {
        val foundIndex = indexOf(it)
        if (foundIndex in 0..<index) {
            index = foundIndex
            match = it
        }
    }
    return match
}

private fun String.findLast(strings: List<String>): String? {
    var index: Int = Int.MIN_VALUE
    var match: String? = null
    strings.forEach {
        val foundIndex = lastIndexOf(it)
        if (foundIndex >= 0 && foundIndex > index) {
            index = foundIndex
            match = it
        }
    }
    return match
}

private fun String.toDigit(): Int = numbersMap[this] ?: toInt()

private val numbersMap = mapOf(
    "zero" to 0,
    "one" to 1,
    "two" to 2,
    "three" to 3,
    "four" to 4,
    "five" to 5,
    "six" to 6,
    "seven" to 7,
    "eight" to 8,
    "nine" to 9
)
private val numbersList = numbersMap
    .map { entry -> listOf(entry.key, entry.value.toString()) }
    .flatten()
