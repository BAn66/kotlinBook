package ch02.expr

interface Expr
class Num(val value: Int) :
    Expr // Простой класс объектов-значений с одним свойством value, реализующим интерфейс Expr

class Sum(val left: Expr, val right: Expr) :
    Expr // Аргументами операции Sum могут быть любые экземпляры Expr: Num или  другой объект Sum


/** java стайл **/
/*
fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num //Это явное приведение к Num, но оно тут излишне
        return n.value
    }
    if (e is Sum){
        return eval(e.right) + eval(e.left) // Переменная e уже приведена к нужному типу
    }
    throw IllegalArgumentException("Неизвестное выражение")
}
*/

/** как тернарный оператор в java возвращаем лишь значения без привидения  **/
/*fun eval(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        eval(e.right) + eval(e.left) // Переменная e уже приведена к нужному типу
    } else {
    throw IllegalArgumentException("Неизвестное выражение")
    }

 */

/** улучшаем через when как в котлин надо **/
/*fun eval(e: Expr): Int =
    when (e) {
        is Num ->       //Ветка when проверяет тип аргумента
            e.value     //Используется автоматическое приведение типов
        is Sum ->       //Ветка when проверяет тип аргумента
            eval(e.right) + eval(e.left) //Используется автоматическое приведение типов
        else ->
            throw IllegalArgumentException("Неизвестное выражение")
    }

 */

/** Улучшенный код с журналированием (выводом сообщений на экран) */
fun eval(e: Expr): Int =
    when (e) {
        is Num -> {      //Ветка when проверяет тип аргумента
            println("num: ${e.value}")
            e.value     //Это последнее выражение в блоке, функция вернет его значение если Num
        }
        is Sum -> {      //Ветка when проверяет тип аргумента
            val left = eval(e.left) //Используется автоматическое приведение типов
            val right = eval(e.right)
            println("sum: $left + $right")
            left + right //Это последнее выражение в блоке, функция вернет его значение если оно sum
        }
        else ->
            throw IllegalArgumentException("Неизвестное выражение")
    }
