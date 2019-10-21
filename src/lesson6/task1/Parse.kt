@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence", "UNUSED_EXPRESSION", "NAME_SHADOWING")

package lesson6.task1

import java.lang.Exception
import java.lang.IllegalArgumentException
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main() {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        } else {
            println("Прошло секунд с начала суток: $seconds")
        }
    } else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}


/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку.
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30.02.2009) считается неверными
 * входными данными.
 */
fun dateStrToDigit(str: String): String {
    val m = listOf(
        "января", "февраля", "марта", "апреля",
        "мая", "июня", "июля", "августа",
        "сентября", "октября", "ноября", "декабря"
    )
    val date: String
    try {
        val (day, month, year) = str.split(" ")
        if (lesson2.task2.daysInMonth(m.indexOf(month) + 1, year.toInt()) < day.toInt())
            return ""
        date = String.format("%02d.%02d.%s", day.toInt(), m.indexOf(month) + 1, year)
        LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"))
    } catch (e: Exception) {
        return ""
    }
    return date

}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 *
 * Обратите внимание: некорректная с точки зрения календаря дата (например, 30 февраля 2009) считается неверными
 * входными данными.
 */
fun dateDigitToStr(digital: String): String {
    val m = listOf(
        "января", "февраля", "марта", "апреля",
        "мая", "июня", "июля", "августа",
        "сентября", "октября", "ноября", "декабря"
    )
    try {
        val arr = digital.split(".")
        if (arr.size != 3)
            return ""
        val (day, month, year) = listOf(arr[0].toInt(), arr[1].toInt(), arr[2].toInt())
        if (lesson2.task2.daysInMonth(month, year) < day)
            return ""

        return String.format("%d %s %s", day, m[month - 1], year)
    } catch (e: Exception) {
        return ""
    }
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -89 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку.
 *
 * PS: Дополнительные примеры работы функции можно посмотреть в соответствующих тестах.
 */
fun flattenPhoneNumber(phone: String): String = TODO()

/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int = TODO()

/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки, а также в случае отсутствия удачных попыток,
 * вернуть -1.
 */
fun bestHighJump(jumps: String): Int = TODO()

/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    require(
        expression.isNotEmpty() &&
                !expression.map { (('0'..'9') + listOf('+', '-', ' ')).contains(it) }.contains(false)
    )
    val arr = expression.split(" ")
    require(!arr.map {
        if (it.length == 1) true else
            !(it[0] == '+' || it[0] == '-')
    }.contains(false))
    var out = 0
    var isNum = true
    var sign = "+"
    arr.forEach {
        if (isNum) {
            out += if (sign == "+") it.toInt() else -it.toInt()
        } else {
            sign = when (it) {
                "+" -> it
                "-" -> it
                else -> throw IllegalArgumentException()
            }
        }
        isNum = !isNum
    }
    return out
}

/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    var arr = str.split(" ").map { it.toLowerCase() }
    val s = arr.filter { str -> arr.count { str == it } > 1 }
    s.forEachIndexed { i, c ->
        if (c == s[i + 1])
            return str.toLowerCase().indexOf("$c $c")
    }
    return -1
}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть больше либо равны нуля.
 */
fun mostExpensive(description: String): String
//    description.split(";")
//        .map {
//            val p = it.trim().split(" ")
//            println(p.toString())
//            Pair(
//                p[0],
//                p[1].toFloat()
//            )
//        }.sortedWith(kotlin.Comparator { o1, o2 ->
//            (o2.second - o1.second).toInt()
//        })
//        .first().first
{
    val l = description.split(";")
    val products = mutableSetOf<Pair<String, Float>>()
    l.forEach {
        val p = it.trim().split(" ")
        if (p.size != 2) return ""
        if (p[1].toFloat() < 0) return ""
        products.add(Pair(p[0], p[1].toFloat()))
    }
    return products.sortedWith(kotlin.Comparator { o1, o2 ->
        (o2.second - o1.second).toInt()
    }).first().first
}

/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 *
 * Вернуть -1, если roman не является корректным римским числом
 */
fun fromRoman(roman: String): Int {
    //в задаче я переведу двоные символы в одинарные. Но изначальный ввод может уже содержать символы, которые я хочу получить только после преобразования
    if (roman.map { "IVXLCDM".contains(it) }.contains(false))
        return -1
    if (roman.isEmpty())
        return -1
    //Рисмкое представление, обозначение в десятичной, используется ли только 1 раз (можно поставить XX, но нелья IXIX)
    val rome = mutableListOf(
        Triple('m', 900, true),
        Triple('M', 1000, false),
        Triple('d', 400, true),
        Triple('D', 500, false),
        Triple('c', 90, true),
        Triple('C', 100, false),
        Triple('l', 40, true),
        Triple('L', 50, false),
        Triple('x', 9, true),
        Triple('X', 10, false),
        Triple('v', 4, true),
        Triple('V', 5, false),
        Triple('I', 1, false)
    )
    var out = 0
    var str = roman
    mapOf(
        "CM" to "m", "CD" to "d", "XC" to "c", "XL" to "l", "IX" to "x", "IV" to "v"
    ).forEach {
        str = str.replace(it.key, it.value)
    }
    str.forEach { c ->
        val elem = rome.find { it.first == c }
        out += elem?.second ?: return -1
        if (elem.third) { // удаляем уже использованный элемент по типу IV IX и тд
            rome.remove(elem)
        }
    }
    return out
}

/**
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> {
    var myLimit = limit
    //проверка на ошибочный ввод команд
    require(!commands.map { listOf('>', '<', '+', '-', '[', ']', ' ').contains(it) }.contains(false))
    //если ] в коде раньше, чем [
    require(commands.indexOf(']') >= commands.indexOf('['))
    require(commands.count { it == '[' } - commands.count { it == ']' } == 0)
    val data = IntArray(cells) { 0 }

    var i = cells / 2 // позиция датчика
    var ip = 0 // номер текущей выполняемой команды

    var b = 0
    //начинаем выполнение инструкций
    while (ip < commands.length) {

        if (myLimit < 0)
            break
        when (commands[ip]) {
            '>' -> if (i >= cells - 1) throw IllegalStateException() else i++
            '<' -> if (i <= 0) throw IllegalStateException() else i--
            '+' -> data[i]++
            '-' -> data[i]--

            '[' -> {
                myLimit++
                if (data[i] == 0) {
                    b++
                    while (b > 0) {
                        ip++
                        myLimit--
                        if (commands[ip] == '[')
                            b++
                        if (commands[ip] == ']')
                            b--
                    }
                }
            }
            ']' -> {
                myLimit++
                if (data[i] != 0) {
                    b++
                    while (b > 0) {
                        ip--
                        if (commands[ip] == '[')
                            b--
                        if (commands[ip] == ']')
                            b++
                    }
                }
            }
        }
        println("lim = $myLimit ip = $ip,\ti = $i,\tcommand = ${commands[ip]},box=${data[i]}  ,data = ${data.toList().toString()}")
        ip++
        myLimit--

    }
    return data.toList()
}
