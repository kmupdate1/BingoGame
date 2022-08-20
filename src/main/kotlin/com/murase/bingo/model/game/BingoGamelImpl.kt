package com.murase.bingo.model.game

import com.murase.bingo.model.game.card.BingoCard
import com.murase.bingo.random

// ビンゴカード作る
class CreateBingoCard: CreatableBingoCard {
    companion object {
        fun getInstance() = CreateBingoCard()
    }

    private val mainBingoCard = listOf(
        BingoCard(-1, -1, false), // ダミーデータ
        BingoCard(1, random(), false),
        BingoCard(2, random(), false),
        BingoCard(3, random(), false),
        BingoCard(4, random(), false),
        BingoCard(5, random(), false),
        BingoCard(6, random(), false),
        BingoCard(7, random(), false),
        BingoCard(8, random(), false),
        BingoCard(9, random(), false)
    )

    override fun getMainBingoCard(): List<BingoCard> = mainBingoCard

    override fun getNumberOnBingoCard(position: Int): Int {
        return if ( position in 1..9 ) {
            mainBingoCard[position].number
        } else {
            -1
        }
    }
}

// ガラポンをする
class LotteryJackpot: HitLotteryJackpot {
    companion object {
        fun getInstance() = LotteryJackpot()
    }

    override fun getLotteryJackpot(): Int = random()
}

/*
// ガラポンの結果を教える
class CheckBingoResult: CheckableBingoResult {
    companion object {
        fun getInstance() = CheckBingoResult()
    }

    override fun isExistsNumber(): Boolean {
        return true
    }

    override fun getBingoResult(): Boolean {
        val bingoCard: CreatableBingoCard = CreateBingoCard.getInstance()

*/
/*
        val result = TODO("ビンゴが決まったか否かを判定した結果を返す")
        return result
*//*

        return true
    }
}
*/
