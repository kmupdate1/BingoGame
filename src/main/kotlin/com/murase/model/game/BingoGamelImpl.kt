package com.murase.model.game

import com.murase.model.game.card.BingoCard
import com.murase.random

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
