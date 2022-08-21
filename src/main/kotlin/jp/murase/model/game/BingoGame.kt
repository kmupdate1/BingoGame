package jp.murase.model.game

import jp.murase.model.game.card.BingoCard

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
