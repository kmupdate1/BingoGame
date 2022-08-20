package com.murase.bingo.model.check

import com.murase.bingo.model.game.CreatableBingoCard
import com.murase.bingo.model.game.card.BingoCard
import com.murase.bingo.util.BingoSet

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
// 赤丸つける場所を通知
class CheckMatchPoint(
    private val matchPositionArray: Array<Int>
): CheckableMatchPoint {
    override fun matchPoint(): Array<String> {
        var positionArray: Array<String> = arrayOf()
        val it: Iterator<Int> = matchPositionArray.iterator()

//        for ( i in markPositionMap ) println(i.value.)

*/
/*
        while ( it.hasNext() ) {
            val next: Int = it.next()
            if ( next > 0 )
                positionArray = arrayOf( markPositionMap.getValue(next).id )
        }
*//*

        return positionArray
    }
}
*/

/*
* 出目に対してビンゴが発生するかを、
* 毎回の出目毎にチェックする。
* */
class CheckBingo: CheckableBingo {
    companion object {
        fun getInstance() = CheckBingo()
    }

    override fun isBingo(): Boolean {
        val isBingo = false


        return false
    }

    /*
        private val bingoCard: CreatableBingoCard = CreateBingoCard.getInstance()
        private val bingoSet = BingoSet().bingoPatternSet

        override fun isBingo(): Boolean {
            val it = bingoSet.iterator()
            while ( it.hasNext() ) {

            }
            return true
        }
    */

}
