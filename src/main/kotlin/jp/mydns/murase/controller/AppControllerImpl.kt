package jp.mydns.murase.controller

import jp.mydns.murase.model.manager.CardManager
import jp.mydns.murase.model.Jackpot
import kotlin.system.exitProcess

class AppControllerImpl: AppController {
    //private val checkNumber: AbstractCheck = CheckNumber()
    //private val checkCard: AbstractCheck = CheckCard()

    override fun create(): CardManager {
        CardManager.create()
        return CardManager
    }

    override fun jackpot(): Int {
        val jackpotNumber = Jackpot.jackpot()


        return jackpotNumber
    }

    override fun reTry() {

    }

    override fun endGame(): Nothing = exitProcess(0)
}
