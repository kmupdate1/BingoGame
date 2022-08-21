package jp.murase

import jp.murase.view.BingoFXView
import tornadofx.*

const val WINDOW_TITLE = "BINGO GAME!"

// ビンゴ数字表示エリア
const val BINGO_AREA_I0J0 = "bingo_area_i0j0"
const val BINGO_AREA_I0J1 = "bingo_area_i0j1"
const val BINGO_AREA_I0J2 = "bingo_area_i0j2"
const val BINGO_AREA_I1J0 = "bingo_area_i1j0"
const val BINGO_AREA_I1J1 = "bingo_area_i1j1"
const val BINGO_AREA_I1J2 = "bingo_area_i1j2"
const val BINGO_AREA_I2J0 = "bingo_area_i2j0"
const val BINGO_AREA_I2J1 = "bingo_area_i2j1"
const val BINGO_AREA_I2J2 = "bingo_area_i2j2"

// ガラポン回すボタン
const val SELECT_RANDOM_NUMBER   = "select_random_number"
// おわりボタン
const val END_BINGO_GAME         = "end_bingo_game"

// ガラポン結果表示エリア
const val RESULT_SELECTED_NUMBER = "result_selected_number"
// ビンゴ結果表示エリア
const val BINGO_RESULT           = "bingo_result"

// ビュー定義ファイル[FXML]
const val FXML_VIEW_RESOURCE = "/BingoFXView.fxml"

// ビンゴ表示に使用する数字の範囲[0 - 99]
const val MIN = 0
const val MAX = 99

const val YES = "YES"
const val NO  = "NO"

fun random(): Int = (MIN..MAX).random()

fun main() = launch<BingoGameApp>()

class BingoGameApp: App(BingoFXView::class)
