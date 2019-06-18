package board

import board.Direction.*

fun createSquareBoard(width: Int): SquareBoard = TODO()

class SquareBoardImpl(override val width: Int) :SquareBoard {

    override fun getCellOrNull(i: Int, j: Int): Cell? {
        return if ((i<=width)||(j<=width)) Cell(i,j) else null
    }

    override fun getCell(i: Int, j: Int): Cell {
        require(i<=width && j<=width)
        return Cell(i,j);
    }

    override fun getAllCells(): Collection<Cell> {
        val cells:List<Cell>  = ArrayList()
        var i = 0
        var j=0
        while ( > 0) {
            x--
        }
    }

    override fun getRow(i: Int, jRange: IntProgression): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Cell.getNeighbour(direction: Direction): Cell? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


//fun <T> createGameBoard(width: Int): GameBoard<T> = {return null}

