package com.murase.bingo.util

import com.murase.bingo.model.game.CreatableBingoCard

class BingoSet(
    private val bingoCard: CreatableBingoCard
) {
    private val bingoNum = bingoCard.getBingoNumberList()

    val bingoPatternSet: Map<Int, List<Int>> = mapOf(
        1 to listOf(bingoNum[1].number, bingoNum[2].number, bingoNum[3].number),
        2 to listOf(bingoNum[4].number, bingoNum[5].number, bingoNum[6].number),
        3 to listOf(bingoNum[7].number, bingoNum[8].number, bingoNum[9].number),
        4 to listOf(bingoNum[1].number, bingoNum[4].number, bingoNum[7].number),
        5 to listOf(bingoNum[2].number, bingoNum[5].number, bingoNum[8].number),
        6 to listOf(bingoNum[3].number, bingoNum[6].number, bingoNum[9].number),
        7 to listOf(bingoNum[1].number, bingoNum[5].number, bingoNum[9].number),
        8 to listOf(bingoNum[3].number, bingoNum[5].number, bingoNum[7].number)
    )
}
