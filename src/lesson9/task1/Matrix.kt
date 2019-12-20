@file:Suppress("UNUSED_PARAMETER", "unused")

package lesson9.task1

/**
 * Ячейка матрицы: row = ряд, column = колонка
 */
data class Cell(val row: Int, val column: Int)

/**
 * Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы
 */
interface Matrix<E> {
    /** Высота */
    val height: Int

    /** Ширина */
    val width: Int

    /**
     * Доступ к ячейке.
     * Методы могут бросить исключение, если ячейка не существует или пуста
     */
    operator fun get(row: Int, column: Int): E

    operator fun get(cell: Cell): E

    /**
     * Запись в ячейку.
     * Методы могут бросить исключение, если ячейка не существует
     */
    operator fun set(row: Int, column: Int, value: E)

    operator fun set(cell: Cell, value: E)
}

/**
 * Простая
 *
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина, e = чем заполнить элементы.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> {
    require(width > 0 && height >= 0)
    return MatrixImpl(height, width, e)
}

/**
 * Средняя сложность
 *
 * Реализация интерфейса "матрица"
 */
class MatrixImpl<E>(override val height: Int, override val width: Int, e: E) : Matrix<E> {

    private val values = MutableList(height) { MutableList(width) { e } }

    init {
        require(width > 0 && height > 0)
    }

    override fun get(row: Int, column: Int): E = values[row][column]

    override fun get(cell: Cell): E = values[cell.row][cell.column]

    override fun set(row: Int, column: Int, value: E) {
        values[row][column] = value
    }

    override fun set(cell: Cell, value: E) {
        values[cell.row][cell.column] = value
    }

    override fun equals(other: Any?) = other is MatrixImpl<*> && other.values == values

    override fun toString(): String = values.joinToString(separator = "\n") { "|\t" + it.joinToString("\t") + "\t|" }
    override fun hashCode(): Int {
        var result = height
        result = 31 * result + width
        result = 31 * result + values.hashCode()
        return result
    }
}

