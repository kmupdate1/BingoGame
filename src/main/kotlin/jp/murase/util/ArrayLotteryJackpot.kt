package jp.murase.util

class ArrayLotteryJackpot {
    private val arrayLotteryJackpotNum: ArrayList<Int> = arrayListOf()

    fun addExtension(number: Int) {
        if ( !arrayLotteryJackpotNum.contains(number) ) {
            arrayLotteryJackpotNum.add(number)
        }
    }

    fun getSize() = arrayLotteryJackpotNum.size
}
