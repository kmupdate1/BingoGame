package com.murase.bingo.model.game

import com.murase.bingo.model.game.card.BingoCard

// ビンゴカード作る
interface CreatableBingoCard {
    // ビンゴカードの
    fun getMainBingoCard(): List<BingoCard>
    // ビンゴカードの指定場所の数字を取得できる
    fun getNumberOnBingoCard(position: Int): Int
}

// ガラポンをする
interface HitLotteryJackpot {
    fun getLotteryJackpot(): Int
}
