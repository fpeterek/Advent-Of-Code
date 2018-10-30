import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt

fun findNearestSquareRoot(num: Int): Int {

    val nearestRoot = ceil(sqrt(num.toDouble())).toInt()

    return if (nearestRoot % 2 == 0) {
        nearestRoot + 1
    } else {
        nearestRoot
    }

}

fun main(args: Array<String>) {

    val input = 325489

    val nearestRoot = findNearestSquareRoot(input)
    val rightBottom = nearestRoot * nearestRoot
    val leftBottom = rightBottom - nearestRoot + 1
    val leftTop = leftBottom - nearestRoot + 1
    val rightTop = leftTop - nearestRoot + 1
    val rightLowest = rightTop - nearestRoot + 2

    val horizontalPos = when (input) {
        in leftTop..leftBottom -> leftTop
        in rightLowest..rightTop -> rightBottom
        else -> input
    }

    val horizontal = if (horizontalPos >= leftBottom) {

        val midVal = leftBottom + (nearestRoot / 2.0).toInt()
        abs(horizontalPos - midVal)

    } else {

        val midVal = rightTop + (nearestRoot / 2.0).toInt()
        abs(horizontalPos - midVal)

    }

    val verticalPosition = when (input) {
        in leftBottom..rightBottom -> leftBottom
        in leftTop..rightTop -> leftTop
        else -> input
    }

    val vertical = if (verticalPosition < leftTop) {

        val midVal = rightTop - (nearestRoot / 2.0).toInt()
        abs(verticalPosition - midVal)

    } else {

        val midVal = leftTop + (nearestRoot / 2.0).toInt()
        abs(verticalPosition - midVal)

    }

    println(horizontal + vertical)

}
