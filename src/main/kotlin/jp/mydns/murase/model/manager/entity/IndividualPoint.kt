package jp.mydns.murase.model.manager.entity

data class IndividualPoint(
    val column: Int,
    val row: Int,
    val number: Int,
    var hit: Boolean = false
)
