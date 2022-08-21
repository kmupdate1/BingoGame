package jp.murase.model.check

// 出目の一致調査
interface CheckableJackpot {
    fun whereNumberExists(): Array<Int>
}

// ビンゴ判定
interface CheckableBingo {
    fun isBingo(): Boolean
}
