package board

import board.Direction.*
import java.util.ArrayList

fun createSquareBoard(width: Int): SquareBoard = SquareBoardImpl(width)

open class SquareBoardImpl(override val width: Int) : SquareBoard {

    protected val cells = Array(width
    ) { i ->
        Array(width){j -> Cell(i + 1, j + 1)}
    }


    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return if ((i <= width) || (j <= width)) cells[i-1][j-1] else null
    }

    override fun getCell(i: Int, j: Int): Cell {
        require(i <= width && j <= width)
        return cells[i-1][j-1]
    }

    override fun getAllCells(): Collection<Cell> {
        return cells.toList().flatMap{arrayOfCells ->arrayOfCells.toList()}
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        val res:MutableList<Cell> = ArrayList()
        for (j in jRange)
            if (j<=width)
                res+=cells[i-1][j-1]
        return res
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        val res:MutableList<Cell> = ArrayList()
        for (i in iRange)
            if (i<=width)
                res+=cells[i-1][j-1]
        return res
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {

        val row:Int
        val col:Int
        when (direction) {
            DOWN -> {row=i+1;col=j}
            UP ->  {row=i-1;col=j}
            LEFT ->  {row=i;col=j-1}
            RIGHT -> {row=i;col=j+1}
        }
        return  if (row in 1..width && col in 1..width) cells[row-1][col-1] else null
    }
}


fun <T> createGameBoard(width: Int): GameBoard<T> = GameBoardImpl(width)

class GameBoardImpl<T>(width: Int) : SquareBoardImpl(width),GameBoard<T> {
    private val cellsData: MutableMap<Cell, T?>

    init {
        this.cellsData = HashMap()
        cells.toList().flatMap { arrayOfCells -> arrayOfCells.toList() }.forEach {
            cellsData[it] = null
        }

    }

    override fun get(cell: Cell): T? {
        return cellsData[cell]
    }

    override fun set(cell: Cell, value: T?) {
        if (value != null) cellsData[cell] = value
    }

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> {
        return cellsData.filterValues(predicate).keys
    }

    override fun find(predicate: (T?) -> Boolean): Cell? {
        return cellsData.filterValues(predicate).keys.first()
    }

    override fun any(predicate: (T?) -> Boolean): Boolean {
        return cellsData.values.any(predicate)
    }

    override fun all(predicate: (T?) -> Boolean): Boolean {
        return cellsData.values.all(predicate)
    }
}

