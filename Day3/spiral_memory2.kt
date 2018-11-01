class Point(var x: Int, var y: Int)


fun main(args: Array<String>) {

    val squares = mutableListOf<MutableList<Int>>()

    for (i in 0..1000) {
        val list = MutableList(1001, fun(_: Int) = 0)
        squares.add(list)
    }

    val p = Point(500, 500)

    squares[p.y][p.x] = 1
    ++p.x
    squares[p.y][p.x] = 1

    while (squares[p.y][p.x] < 325489) {

        if (squares[p.y][p.x - 1] != 0 && squares[p.y - 1][p.x] == 0) {
            --p.y
        } else if (squares[p.y][p.x - 1] == 0 && squares[p.y + 1][p.x] != 0) {
            --p.x
        } else if (squares[p.y + 1][p.x] == 0 && squares[p.y][p.x + 1] != 0) {
            ++p.y
        } else if (squares[p.y][p.x + 1] == 0 && squares[p.y - 1][p.x] != 0) {
            ++p.x
        }

        squares[p.y][p.x] = arrayOf(
            squares[p.y - 1][p.x - 1], squares[p.y - 1][p.x], squares[p.y - 1][p.x + 1], // Row above
            squares[p.y][p.x - 1],     squares[p.y][p.x],     squares[p.y][p.x + 1], // Current row
            squares[p.y + 1][p.x - 1], squares[p.y + 1][p.x], squares[p.y + 1][p.x + 1] // Row below
        ).sum()

    }

    println(squares[p.y][p.x])

}
