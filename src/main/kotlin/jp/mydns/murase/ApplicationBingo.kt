package jp.mydns.murase

import jp.mydns.murase.view.BingoFXView
import tornadofx.*

const val WINDOW_TITLE = "BINGO GAME"

//タイトルエリア
const val TITLE_AREA = "title_area"
// ビンゴエリア
const val GRID_PANE = "grid_pane"
// ボタン
const val BUTTON_JACKPOT = "button_jackpot"
const val BUTTON_END     = "button_end"
const val BUTTON_RETRY   = "button_retry"

// ガラポン結果表示エリア
const val JACKPOT_NUMBER = "jackpot_number"
// ビンゴ結果表示エリア
const val BINGO_RESULT = "bingo_result"

// ビュー定義ファイル[FXML]
const val FXML_VIEW_RESOURCE = "/BingoFXView.fxml"

// ビンゴ表示に使用する数字の範囲[0 - 99], ダミー番号は[-1]
const val MIN   = 0
const val MAX   = 99
const val DUMMY = -1

// ビンゴの状態を結果として現す
const val BINGO   = "BINGO"
const val PERFECT = "PERFECT"

// other
const val LABEL_JACKPOT = "Jackpot"

// widget number

const val TITLE   = 30
const val NUMBER  = 31
const val JACKPOT = 32
const val RETRY   = 33
const val END     = 34
const val RESULT  = 35

fun random(): Int = (MIN..MAX).random()

fun main() = launch<ApplicationBingo>()

class ApplicationBingo: App(BingoFXView::class)
