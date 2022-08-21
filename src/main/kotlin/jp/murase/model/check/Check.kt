package jp.murase.model.check

import jp.murase.manage.ManageLotteryNumber
import jp.murase.model.game.CreatableBingoCard

/*
* ビューの方で出目を渡してくれる。
* その出目が一致するか否か判断する。
* 一致した場合は、一致した場所リストを返す。
* */
class CheckJackpot(
    private val jackpotNumber: Int,
    private val bingoCard: CreatableBingoCard
): CheckableJackpot {
    override fun whereNumberExists(): Array<Int> {
        var positions: Array<Int> = arrayOf()
        for ( i in (1..9) ) {
           if ( bingoCard.getNumberOnBingoCard(i) == jackpotNumber ) {
               bingoCard.getMainBingoCard()[i].hit = true
               positions = arrayOf(i)
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
