package com.murase.bingo.model.check


// 出目の一致調査
interface CheckableJackPot {
    fun whereNumberExists(): Array<Int>
}

// 出目の一致場所調査
interface CheckableMatchPoint {
    fun matchPoint(): Array<String>
}

// ビンゴ判定
interface CheckableBingo {
    fun isBingo(): Boolean
}
