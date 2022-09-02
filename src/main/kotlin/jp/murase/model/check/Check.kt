package jp.murase.model.check

import jp.murase.manage.ManageLotteryNumber
import jp.murase.model.game.CreatableBingoCard
import jp.murase.model.game.CreateBingoCard


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
               bingoCard.getMainBingoCardList()[i].hit = true
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
    private val manager: ManageLotteryNumber,
    private val createBingoCard: CreatableBingoCard
): CheckableBingo {
    companion object {
        fun getInstance(
            manager: ManageLotteryNumber,
            createBingoCard: CreatableBingoCard) = CheckBingo(manager, createBingoCard)
    }

    override fun status(): Int {
        val sizeOfArray = arrayListOf<Int>()
        var status = -1
        val managerList = manager.getManageList()
        for (map in managerList) {
            println("size:${map.value.getSize()}, lene:${map.key}")
            sizeOfArray.add(map.value.getSize())
        }
        println("---------------------------------------------------------------")
        var total = 0
        for (size in sizeOfArray) {
            total += size
        }

        println("total size:$total")
        for ( bingoCard in createBingoCard.getMainBingoCardList() ) println("card hit is ${bingoCard.hit}")

        if (total in 2 .. 3)    status = BINGO_STATUS_OK
        if (sizeOfArray.contains(2)) status = BINGO_STATUS_REACH
        if (sizeOfArray.contains(3)) status = BINGO_STATUS_BINGO
        if (total > 23)              status = BINGO_STATUS_PERFECT

        return status
    }
}
