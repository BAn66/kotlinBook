package ch02.colors

import ch02.colors.Color.*

enum class Color( // Значения свойств определяются
    val r: Int,
    val g: Int,
    val b: Int // .....- дпя каждой константы
) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0), // <J ОбъяВление свойств констант перечисnения
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238); // <J- Точка с запятой здесьобязатепыа

    fun rgb() = (r * 256 + g) * 256 + b // <J- Оnредепение метода кпасса перечиспения
}

fun getMnemonic(color: Color) =
    when (color) {
        RED -> "Каждый"
        ORANGE -> "Охотник"
        YELLOW -> "Желает"
        GREEN -> "Знать"
        BLUE -> "Где"
        INDIGO -> "Сидит"
        VIOLET -> "Фазан"
    }

fun getWarmth(color: Color) =
    when (color) {
        RED, ORANGE, YELLOW -> "Теплый"
        GREEN -> "Нейтральный"
        BLUE, INDIGO, VIOLET -> "Холодный"
    }

fun mix(c1: Color, c2: Color) = //Использование оператора <<when>> с произвольными объектами
    when (setOf(c1, c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> println("Грязный цвет")
    }

fun mixOptimized(c1: Color, с2: Color) = //Выражение <<when>> без арrументов
    when {
        (c1 == RED && с2 == YELLOW) || (c1 == YELLOW && с2 == RED) -> ORANGE
        (c1 == YELLOW && с2 == BLUE) || (c1 == BLUE && с2 == YELLOW) -> GREEN
        (c1 == BLUE && с2 == VIOLET) || (c1 == VIOLET && с2 == BLUE) -> INDIGO
        else -> println("Грязный цвет")
    }