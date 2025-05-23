package org.dimanu.tictactoe

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertTrue

class WinningRulesShould {

    @ParameterizedTest
    @MethodSource("horizontalWinningRules", "verticalWinningRules", "diagonalWinningRules")
    fun `detect wins`(markedTiles: List<Tile>) {
        val winningRules = WinningRules()

        assertTrue(winningRules.matches(markedTiles))

    }

    companion object {
        @JvmStatic
        fun horizontalWinningRules() = listOf(
            listOf(Tile.TOP_LEFT, Tile.TOP_MIDDLE, Tile.TOP_RIGHT),
            listOf(Tile.MIDDLE_LEFT, Tile.MIDDLE_MIDDLE, Tile.MIDDLE_RIGHT),
            listOf(Tile.BOTTOM_LEFT, Tile.BOTTOM_MIDDLE, Tile.BOTTOM_RIGHT)
        )

        @JvmStatic
        fun verticalWinningRules() = listOf(
            listOf(Tile.TOP_LEFT, Tile.MIDDLE_LEFT, Tile.BOTTOM_LEFT),
            listOf(Tile.TOP_MIDDLE, Tile.MIDDLE_MIDDLE, Tile.BOTTOM_MIDDLE),
            listOf(Tile.TOP_RIGHT, Tile.MIDDLE_RIGHT, Tile.BOTTOM_RIGHT),
        )

        @JvmStatic
        fun diagonalWinningRules() = listOf(
            listOf(Tile.TOP_LEFT, Tile.MIDDLE_MIDDLE, Tile.BOTTOM_RIGHT),
            listOf(Tile.TOP_RIGHT, Tile.MIDDLE_MIDDLE, Tile.BOTTOM_LEFT)
        )
    }
}