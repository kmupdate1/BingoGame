package com.murase.bingo.util

class ArrayLotteryJackpot {
    private val arrayLotteryJackpotNum: ArrayList<Int> = arrayListOf()

    fun addExtension(number: Int) {
        if ( !arrayLotteryJackpotNum.contains(number) ) {
            arrayLotteryJackpotNum.add(number)
        }
    }
}
