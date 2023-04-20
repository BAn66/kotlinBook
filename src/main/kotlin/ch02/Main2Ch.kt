package ch02
import ch02.*
import ch02.fizzBuzz.fizzBuzz
import com.sun.jdi.InvalidTypeException
import java.io.BufferedReader
import java.io.StringReader
import java.lang.NumberFormatException
import java.util.*

fun main(args: Array<String>) {
/*
    -Объявление функции начинается с ключевого слова fun. Ключевые
            слова val и var служат для объявления констант и изменяемых переменных соответственно.
    - Строковые шаблоны помогают избежать лишних операций конкатенации строк. Добавьте к переменной префикс $ или заключите
    выражение в ${} - и соответствующее значение будет подставлено
    в строку.
    - В Kotlin можно очень лаконично описывать классы объектов-значе
    нии.
    - Знакомый оператор if теперь является выражением и возвращает
    значение.
    - Выражение when - более мощный аналог выражения switch в Java.
    - Исчезла необходимость явно выполнять приведение типа после
            проверки типа переменной: благодаря механизму автоматического
    приведения типов компилятор сделает это за вас.
    - Циклы for, while и do-while похожи на свои аналоги в Java, но цикл
    for стал более удобным, особенно при работе со словарями или коллекциями с индексом.
   - Лаконичный синтаксис 1 . . 5 создает диапазон.Диапазоны и прогрессии позволяют использовать единый синтаксис и набор абстракций
    для цикла for, а с помощью операторов in и !in можно проверить
    принадлежность значения диапазону.
    - Обработка исключений в Kotlin выполняется почти так же, как в Java,
    лишь с той разницей, что Kotlin не требует перечислять контролируемые исключения, которые может возбуждать функция.
 */

    /**Исключения в КОТлин*/
    //Ошибка при загрузке проценты вариант 1
   /* val number : Int = 200
    val percentage =
        if(number in 0 .. 100)
           println(number)
        else
            throw IllegalArgumentException(
                "А percentage value must Ье between 0 and 100 : $number"
            )
    */

    //Ошибка при загрузке проценты вариант 2
    /*val percentage = 200
    if (percentage !in 0..100){
        throw IllegalArgumentException(
            "А percentage value must Ье between 0 and 100 : $percentage"
        )
    }
    */

        /** try catch finally */
    /*fun readNumber(reader: BufferedReader) : Int? { //Не требуется явно указывать какое исключение может возбудить функция
       try {
           val line = reader.readLine()
           return Integer.parseInt(line)
       }
       catch (e: NumberFormatException){ //Тип исключения записывается справа
           return null
       }
        finally { //Блок finally действует также как в Java
            reader.close()
        }
    }

    val reader = BufferedReader(StringReader("239"))
    println(readNumber(reader))
     */

    //Try как выражение
    /*    fun readNumber(reader: BufferedReader){
            val number = try{
                Integer.parseInt(reader.readLine())
            }catch (e: NumberFormatException){
                null
            }
            println(number)
        }

    val reader = BufferedReader(StringReader("not a number"))
    readNumber(reader) //Выведет значение блока try, а при возбуджении исключения выдаст null, при этом само сообщение об исключении не вылезет

     */

/**Итерация по элементам словарей*/

    /*val binaryReps = TreeMap<Char, String>() //Словарь TreeMap хранит ключи в порядке сортировки
    for (c in 'A'..'F'){ //Обход диапазона символов от A до F
        val binary = Integer.toBinaryString(c.toInt()) //Преобразует ASCII код в двоичное представление
        binaryReps[c] = binary //сохраняет в словаре значение с ключем в с
    }

    for ((letter, binary) in binaryReps){ //Обход элементов словаря, ключ и значение присваиваются двум переменным
        println("$letter = $binary")
    }

    // Обход коллекции с сохранением индекса
    val list = arrayListOf("10","11", "1001")
    for ((index, element) in list.withIndex()){
        println("$index : $element")
    }
    */

/** Использование in для проверки входждения в диапазон или коллекцию */
    /*fun isLetter(c : Char) = c in 'a'..'z' || c in 'A' .. 'Z' //c in 'a'..'z' преобразуется в a <= c <= z
    fun isNotDigit(c : Char) = c !in '0'..'9'

    println(isLetter('q'))
    println(isNotDigit('q'))


    //Использование in и !in в when
    fun recognize(c : Char) = when(c){
        in '0'..'9' -> "Это цифра" // проверяет вхождение в диапазон от 0 до 9
        in 'a'..'z', in 'A' ..'Z' ->  "Это буква" //Можно использовать несколько диапазонов
        else -> "Неведомая хтонь"
    }

    println(recognize('q'))


    println("Kotlin" in "Java".."Scala") //TRUE Сравнение по алфавиту(реализуется интерфейс Comparable), тоже самое как было бы "Java"<="Kotlin"&&"Kotlin"<="Scala"
    println("Kotlin" in setOf("Java", "Scala")) // FALSE котлин не входит в множество "Java", "Scala"
    */

/** Циклы */

/*    val oneToTen = 1..10 //это диапазон, через 2 точки

    // Диапазон закрытый, т.е. включает оба значения и 1 и 100
    // если нужен открытый то пишется (x in 0 until size)
    for (i in 1..100) { //Так цикл как for i в java
        print(fizzBuzz(i))
    }

    println("")

    //Обход прогрессии с шагом
    for (i in 100 downTo 1 step 2) { //счет выполняется в обратном порядке и рассматриваются только четные числа
        print(fizzBuzz(i))
    }
    */

/*        println("______________Вычисления___________________")
            println(eval(Sum(Sum(Num(1), Num(2)), Num(4))))
*/

/*       println("______________ЦВЕТА___________________")
        println(INDIGO.rgb()) //выводит 4915330
        println(getMnemonic(INDIGO)) //Сидит
        println(getWarmth(INDIGO)) // Холодный
        println(mix(ORANGE, GREEN))// Грязный
        println(mixOptimized(YELLOW, RED))// Оранжевый
*/

}