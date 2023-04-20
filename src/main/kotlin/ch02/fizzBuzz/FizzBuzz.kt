package ch02.fizzBuzz

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz " //если остаток от деления 0 то число делится и на 5 и на 3, т.е. на 15
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i " // если число не делится ни на 5, ни на 3 до возвращается само
}