package com.murase.bingo.model.game

import com.murase.bingo.model.game.card.BingoCard

// ビンゴカード作る
interface CreatableBingoCard {
    // ビンゴカードの
    fun getBingoNumberList(): List<BingoCard>
    // ビンゴカードの指定場所の数字を取得できる
    fun getNumberOnBingoCard(position: Int): Int
}

// ガラポンをする
interface JackpotLotteryNumber {
    fun getLotteryNumber(): Int
}

// ガラポンの結果、ヒット判定を知る
interface CheckableBingoResult {
    fun isExistsNumber(): Boolean
    fun getBingoResult(): Boolean
}
