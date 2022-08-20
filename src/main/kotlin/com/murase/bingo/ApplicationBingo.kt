package com.murase.bingo

import com.murase.bingo.view.BingoFXView
import tornadofx.*

const val WINDOW_TITLE = "BINGO GAME!"
const val BINGO_VIEW = "BingoFXView"

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

// ビンゴ赤丸表示エリア
const val BINGO_AREA_EFFECT_I0J0 = "bingo_area_effect_i0j0"
const val BINGO_AREA_EFFECT_I0J1 = "bingo_area_effect_i0j1"
const val BINGO_AREA_EFFECT_I0J2 = "bingo_area_effect_i0j2"
const val BINGO_AREA_EFFECT_I1J0 = "bingo_area_effect_i1j0"
const val BINGO_AREA_EFFECT_I1J1 = "bingo_area_effect_i1j1"
const val BINGO_AREA_EFFECT_I1J2 = "bingo_area_effect_i1j2"
const val BINGO_AREA_EFFECT_I2J0 = "bingo_area_effect_i2j0"
const val BINGO_AREA_EFFECT_I2J1 = "bingo_area_effect_i2j1"
const val BINGO_AREA_EFFECT_I2J2 = "bingo_area_effect_i2j2"

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
// マーカ画像のパスとファイル名
const val CIRCLE_MARKER_IMAGE = "/bingo/image/circle_red.png"

// ビンゴ表示に使用する数字の範囲[0 - 99]
const val MIN = 0
const val MAX = 99

fun random(): Int = (MIN..MAX).random()

fun main() = launch<BingoGameApp>()

class BingoGameApp: App(BingoFXView::class)
