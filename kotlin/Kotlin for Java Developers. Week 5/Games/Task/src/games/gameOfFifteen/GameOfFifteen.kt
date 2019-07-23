package games.gameOfFifteen

import board.*
import games.game.Game
import games.game2048.moveValues
import games.game2048.moveValuesInRowOrColumn


/*
 * Implement the Game of Fifteen (https://en.wikipedia.org/wiki/15_puzzle).
 * When you finish, you can play the game by executing 'PlayGameOfFifteen'.
 */
fun newGameOfFifteen(initializer: GameOfFifteenInitializer = RandomGameInitializer()): Game =
        GameImpl(initializer)


fun GameBoard<Int?>.values() : List<Int?>  {
   val list = mutableListOf<Int?>()
   this.getAllCells().forEach{list.add(this[it])}
   return list
}


class GameImpl(private val initializer: GameOfFifteenInitializer) : Game {

   private val board = createGameBoard<Int?>(4)

    override fun initialize() {

        board.getAllCells().forEachIndexed{index, cell ->
           board[cell]=initializer.initialPermutation.getOrNull(index)
        }

    }

    override fun canMove(): Boolean { return  true}

    override fun hasWon(): Boolean {
        val allCells = board.values()
        for (i in 0..13)
        {
            if (allCells[i]?:0>allCells[i+1]?:0) return false
        }
       return  true
    }

    override fun processMove(direction: Direction) {
        val reversedDirection=
        when (direction) {
            Direction.RIGHT -> Direction.LEFT
            Direction.LEFT ->Direction.RIGHT
            Direction.UP ->Direction.DOWN
            Direction.DOWN ->Direction.UP
        }

       with (board) {
           val cell = find { it == null }!!
           val neighbour = cell.getNeighbour(reversedDirection)
           if (neighbour != null) {
               set(cell,get(neighbour))
               set(neighbour,null)
           }
       }
    }

    override operator fun get(i: Int, j: Int): Int? {
       with(board){
          return get(getCell(i,j))
       }
    }



}


