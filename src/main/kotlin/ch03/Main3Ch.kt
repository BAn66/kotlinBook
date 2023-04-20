package ch03

import ch02.expr.eval
import ch03.strings.joinToString
import ch03.strings.lastChar as last //не забываем импортировать функцию-расширение, можно со своим имененем через as
import java.util.*
import javax.swing.JPopupMenu
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun main(args: Array<String>) {
    /** 3.5 Работа со строками и регулярными выражениями*/
    /** Разбиение строк*/
//    println("12.345-6.А".split("\\.|-".toRegex())) //делим по всем перечисленным в кавычках знакам препинания, ЭТО явная передача регулярного выражения
//    // \ это символ экранирования для указания точки | это символ ИЛИ сплит или по точке, или по тире
//    println("12.345-6.А".split(".","-")) // то же самое что и выше, только без регекс
//    println("12.345-6.А".split('.','-')) // то же самое что и выше, только без кавчек. У сплита много перегруженных методов

    /**Реrулярные выражения и строки в тройных кавычках*/
    //Разбиение пути файла на компоненты: каталог имя файла
    //и расширение с помощью функций substringBeforeLast и substringAfterLast
//    fun parsePath(path: String){
//        val directory = path.substringBeforeLast("/")
//        val fullName = path.substringAfterLast("/")
//        val fileName = fullName.substringBeforeLast(".")
//        val extension = fullName.substringAfterLast(".")
//    }

    //Разбиение пути файла на компоненты: каталог имя файла
    //и расширение с помощью регулярных выражений
//    fun parsePath(path: String) {
//        val regex = """ (.+)/(.+)\.(.+)""".toRegex() //В тройных кавычках можно не экранировать символы, например \. вместо \\.
//        // Шаблон (.+) значит любой символ до последнего указанного знака. до последнего / или до последней. в этом примере
//        val matchResult = regex.matchEntire(path)
//        if(matchResult !=null){
//            val (directory, filename, extension) = matchResult.destructured//что то про мультидекларацию
//            println("Dir: $directory, name: $filename, ext: $extension")
//        }
//    }

    /**многострочные литералы в тройных кавычках*/
    val kotlinLogo = """| //
                       .|//
                       .|/\
                       """
    println(kotlinLogo.trimMargin(".")) //удаляет отступы и указанные префиксы для форматирования указанные символы

    /** 3.4 Работа  с коллекциями*/
    /** функция принимающая произвольное число аргументов */
//    // fun <T> listOf(vararg values: T): List<T>{...} //для этого перед параметром пишем vararg
//
//
//
//    val listArgs = listOf("args: ", *args) //значок * звездочки распаковыввает содержимое массива
//    println(listArgs)
//
//    /**Работа с парами(словорями) инфиксные вызовы и мультидеклараци */
//    val map = mapOf(1 to "one", 7 to "seven", 53 to "fifty-there") //в объявлении указан инфиксный вызов вместо 1.to("one") вызова метода
//    //имя метода помещается между именем целевого объекта и параметром без доп. разделителей
//    val (number, name) = 1 to "one" // в скобках это мультидекларация, а при присвоении через to, можно любые пары присваивать list to list.size() например
//    //infix fun Any . to(other : Any) = Pair(this , other) // пример инфиксной фукнции. функции которые можно вызывать без скобок, у них обязательно один параметр



    /** 3.3 Добавление методов в сторонние классы: функции-расширения и свойства-расширения*/
    /** Входные данные для этого урока*/
//    val list = listOf(1,2,3)
//    println(list) //[1, 2, 3]

//    println("Kotlin".last()) //Вызов функции-расширения
//    println(list.joinToString(separator = ";", prefix = "(", postfix = ")"))

    /** 3.2 Упрощение вызова функций*/


    // Начальная реализация joinToString
   /* fun <T> joinToString(
        collection: Collection<T>,
        separator: String,
        prefix: String,
        postfix: String
    ) : String{

    val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()){
            if (index > 0 ) result.append(separator) // Не нужно вставлять разделитель перед первым символом2
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }
    */

    //Значение параметров по умолчанию
    //Объявление joinToString со значениями по умолчанию
    /*fun <T> joinToString(
        collection: Collection<T>,
        separator: String = ", ",
        prefix: String = "<",
        postfix: String = ">"
    ) : String{

        val result = StringBuilder(prefix)

        for ((index, element) in collection.withIndex()){
            if (index > 0 ) result.append(separator) // Не нужно вставлять разделитель перед первым символом2
            result.append(element)
        }

        result.append(postfix)
        return result.toString()
    }
*/

    /*val list2 = listOf(1,2,3)
    println(joinToString(list2, ":", "(", ")"))

    //Вызов значений по умолчанию или не полностью указав
        println(joinToString(list2))
        println(joinToString(list2, ":", "("))
    // Именнованые аргументы/
    println(joinToString(list , separator = " ", prefix = "", postfix = "." ))
    */





/** Создание коллекций*/
/*    val set = hashSetOf(1, 7, 53) // Множество
    val list = arrayListOf(1, 7, 53) // Список
    val map = hashMapOf(1 to "one", 7 to "seven", 53 to "fifty-three") //Карта, мапа, словарь

    println(list.last())
    println(set.maxOrNull())//Методы работы с коллекциями такие же как в Java ну или почти

    val heap = hashSetOf(set, list, map)
    for (a in heap){
        printClz(a)
    }
}

fun printClz(objict: Cloneable) {
    println(objict.javaClass) //метод вывода класса в Java
*/


}


