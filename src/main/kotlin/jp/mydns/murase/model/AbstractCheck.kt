package jp.mydns.murase.model

import jp.mydns.murase.model.manager.CardManager

abstract class AbstractCheck {
    private val cardManager = CardManager
    private val cardListIterator = cardManager.getCardListIterator()

    fun check() {
        while ( cardListIterator.hasNext() ) {

        }
    }

    abstract fun checkNumber(jackpotNumber: Int): Boolean
    abstract fun checkCard(jackpotNumber: Int): Boolean
}
