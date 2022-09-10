package jp.mydns.murase.controller

import jp.mydns.murase.model.manager.CardManager

interface AppController {

    fun create(): CardManager

    fun jackpot(): Int
    fun reTry(): Unit
    fun endGame(): Nothing
}
