package com.murase.model.game.card

data class BingoCard(
    val position: Int,
    val number:   Int,
    var hit:      Boolean
)
