package jp.mydns.murase.model.manager

import jp.mydns.murase.DUMMY
import jp.mydns.murase.model.manager.entity.IndividualPoint
import jp.mydns.murase.random
import jp.mydns.murase.view.MAX_COLUMN
import jp.mydns.murase.view.MAX_ROW

object CardManager {
    private val cardList =
        mutableListOf(
            // 1つ目はダミーとして初期化
            IndividualPoint(
                DUMMY,
                DUMMY,
                DUMMY
            )
        )

    fun create() {
        for ( i in 0 until MAX_COLUMN )
            for ( j in 0 until MAX_ROW )
                cardList += IndividualPoint(i, j, random())
    }

    fun getCardListIterator(): MutableIterator<IndividualPoint> = cardList.iterator()
}
