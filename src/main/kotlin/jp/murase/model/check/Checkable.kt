package jp.murase.model.check

const val BINGO_STATUS_OK      = 0
const val BINGO_STATUS_REACH   = 1
const val BINGO_STATUS_BINGO   = 10
const val BINGO_STATUS_PERFECT = 100
// 出目の一致調査
interface CheckableJackpot {
    fun whereNumberExists(lotteryNumber: Int): ArrayList<Int>
}

// ビンゴ判定
interface CheckableBingo {
    fun status(): Int
}
