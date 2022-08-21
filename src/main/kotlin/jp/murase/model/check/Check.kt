package jp.murase.model.check

import jp.murase.manage.ManageLotteryNumber
import jp.murase.model.game.CreatableBingoCard

/*
* ビューの方で出目を渡してくれる。
* その出目が一致するか否か判断する。
* 一致した場合は、一致した場所リストを返す。
* */
class CheckJackpot(
    private val bingoCard: CreatableBingoCard
): CheckableJackpot {
    companion object {
        fun getInstance(bingoCard: CreatableBingoCard) = CheckJackpot(bingoCard)
    }
    override fun whereNumberExists(lotteryNumber: Int): ArrayList<Int> {
        val positions: ArrayList<Int> = arrayListOf()
        var index = 0
        for ( i in (1..9)) {
           if ( bingoCard.getNumberOnBingoCard(i) == lotteryNumber ) {
               bingoCard.getMainBingoCard()[i].hit = true
               positions.add(index++, i)
           }
        }
        return positions
    }
}

/*
* 出目に対してビンゴが発生するかを、
* 毎回の出目毎にチェックする。
* */
class CheckBingo(
    private val manager: ManageLotteryNumber
): CheckableBingo {
    companion object {
        fun getInstance(manager: ManageLotteryNumber) = CheckBingo(manager)
    }

    override fun isBingo(): Boolean {
        var isBingo = false
        val managerList = manager.getManageList()
        for ( array in managerList ) {
            if ( array.getSize() > 2 ) isBingo = true
        }
        return isBingo
    }
}
