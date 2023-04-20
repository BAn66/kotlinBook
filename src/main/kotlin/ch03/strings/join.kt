@file: JvmName("StringFunctions") // Аннотация необходимая для изменения имени класса с Kotlin функциями вернхнеого уровня, размещать перед пакэйджем
/*в Java ее можно будет вызвать:
import strings.StringFunctions;
StringFunctions.joinToString(list, ",", "(", ")");
*/
package ch03.strings

import ch02.expr.eval


/** 3.2.3 Свойства и вызовы на верхнем уровне файла, вне класса */

var opCount = 0 //Объявление свойства верхнего уровня
fun perfomOperation() { //Изменение значения свойства
    opCount++
}

fun reportOperationCount() {
    println(" Operation perfomed $opCount times") //Чтение значения свойства
}

const val UNIX_LINE_SEPARATOR = "\n" //Определяем константу в коде // аналог в java public final static String UNIX_LINE_SEPARATOR = "\n";

/* старая версия
fun <T> joinToString(

    collection: Collection<T>, //функция на верхнем уровне файла
    separator: String = ", ",
    prefix: String = "<",
    postfix: String = ">"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator) // условие для определения того что, не нужно вставлять разделитель перед первым символом
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}
*/

/* Новая версяи как функция расширения типа Collection<T> */
fun <T> Collection<T>.joinToString(
    separator: String = ", ", //Значения по умолчанию для параметров
    prefix: String = "<",
    postfix: String = ">"
): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) { //this ссылается на объект-приемник: коллекцию значения типа Т //Так же здесь пример мультидекларации
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}
//fun <T> List<T> . last( ) : T { /* возвращает последний элемент */ }
//fun Collection<Int> .max( ) : Int { /* отыскивает максимальное значение в коллекции */ }

/** Функция-расширение:*/
//fun String.lastChar(): Char = this.get(this.length - 1) //Функция-расширение: метод получения последнего символа в строке.
// Функция-расширения это та которая вызываться как член класса но определена за его пределами
//String это тип-получатель, а this.get(this.length-1) это объект получатель( тот который this)
fun String.lastChar(): Char = get(length - 1) // К методам объекта получателя можно обращаться без this

/**Свойство-расширение: */
//val StringBuilder.lastChar(): Char
//get() = get(length - 1)
//        set(value: Char){
//            this.setCharAt(length - 1, eval())
//        }
