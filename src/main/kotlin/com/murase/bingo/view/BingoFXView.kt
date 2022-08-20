package com.murase.bingo.view

import com.murase.bingo.*
import com.murase.bingo.control.ManageLotteryNumber
import com.murase.bingo.model.check.*
import com.murase.bingo.model.game.*
import javafx.beans.property.SimpleStringProperty
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.layout.VBox
import tornadofx.*
import kotlin.system.exitProcess

class BingoFXView: View(WINDOW_TITLE) {
    private val createBingoCard: CreatableBingoCard = CreateBingoCard.getInstance()
    private val lotteryJackpot:  HitLotteryJackpot  = LotteryJackpot.getInstance()
    private val checkBingo:      CheckableBingo     = CheckBingo.getInstance()

    private val lotteryJackpotManager = ManageLotteryNumber()

    override val root: VBox by fxml(FXML_VIEW_RESOURCE)

    //　チェックボックスがオフの時のみを考えて実装する

    // 各種ウィジェットを取得
    // ビンゴカードエリア
    private val bingoAreaI0J0: Label by fxid(BINGO_AREA_I0J0)
    private val bingoAreaI0J1: Label by fxid(BINGO_AREA_I0J1)
    private val bingoAreaI0J2: Label by fxid(BINGO_AREA_I0J2)
    private val bingoAreaI1J0: Label by fxid(BINGO_AREA_I1J0)
    private val bingoAreaI1J1: Label by fxid(BINGO_AREA_I1J1)
    private val bingoAreaI1J2: Label by fxid(BINGO_AREA_I1J2)
    private val bingoAreaI2J0: Label by fxid(BINGO_AREA_I2J0)
    private val bingoAreaI2J1: Label by fxid(BINGO_AREA_I2J1)
    private val bingoAreaI2J2: Label by fxid(BINGO_AREA_I2J2)

/*
    // ガラポン回転ボタン
    private val selectRandomNumber: Button by fxid(SELECT_RANDOM_NUMBER)

    // ビンゴゲーム終了ボタン
    private val endBingoGame: Button by fxid(END_BINGO_GAME)
*/

    // 出目表示エリア
    private val resultSelectedNumber: Label by fxid(RESULT_SELECTED_NUMBER)

    // ビンゴ結果表示エリア
    private val bingoResult: Label by fxid(BINGO_RESULT)

    // ビンゴカードエリアを論理的に初期化
    private val bingoAreaI0J0Value = SimpleStringProperty()
    private val bingoAreaI0J1Value = SimpleStringProperty()
    private val bingoAreaI0J2Value = SimpleStringProperty()
    private val bingoAreaI1J0Value = SimpleStringProperty()
    private val bingoAreaI1J1Value = SimpleStringProperty()
    private val bingoAreaI1J2Value = SimpleStringProperty()
    private val bingoAreaI2J0Value = SimpleStringProperty()
    private val bingoAreaI2J1Value = SimpleStringProperty()
    private val bingoAreaI2J2Value = SimpleStringProperty()

    // 出目および結果表示エリアを論理的に初期化
    private val resultSelectedNumberValue = SimpleStringProperty()
    private val bingoResultValue          = SimpleStringProperty()

    // ビンゴの準備する
    private fun pushSelectNumberButton() {
        // ビンゴカード作る
        bingoAreaI0J0Value.value = createBingoCard.getNumberOnBingoCard(1).toString()
        bingoAreaI0J1Value.value = createBingoCard.getNumberOnBingoCard(2).toString()
        bingoAreaI0J2Value.value = createBingoCard.getNumberOnBingoCard(3).toString()
        bingoAreaI1J0Value.value = createBingoCard.getNumberOnBingoCard(4).toString()
        bingoAreaI1J1Value.value = createBingoCard.getNumberOnBingoCard(5).toString()
        bingoAreaI1J2Value.value = createBingoCard.getNumberOnBingoCard(6).toString()
        bingoAreaI2J0Value.value = createBingoCard.getNumberOnBingoCard(7).toString()
        bingoAreaI2J1Value.value = createBingoCard.getNumberOnBingoCard(8).toString()
        bingoAreaI2J2Value.value = createBingoCard.getNumberOnBingoCard(9).toString()
    }

    // ガラポンボタン押す
    @FXML
    fun garaPon() {

        // ガラポン番号の取得および、出目の表示
        val lotteryNumber: Int = lotteryJackpot.getLotteryJackpot()
        resultSelectedNumberValue.value = lotteryNumber.toString()
        lotteryJackpotManager.setLotteryNumber(lotteryNumber)

        // 出目の一致を判定するためのオブジェクト取得および、一致した際の位置一覧を取得
        val checkJackpot: CheckableJackpot = CheckJackpot(lotteryNumber, createBingoCard)
        val matchPositionArray: Array<Int> = checkJackpot.whereNumberExists()

        // デバッグ
        for ( matchPosition in matchPositionArray ) println(matchPosition)

        // エフェクトつける

        // ビンゴかチェックする
        checkBingo
        val isBingo = checkBingo.isBingo()


        // 先ほど取得した位置一覧を与える
//        val checkMatchPoint: CheckableMatchPoint = CheckMatchPoint(matchPositionArray)




        // 文字エフェクトをつける場所一覧を取得
  //      val positionArray: Array<String> = checkMatchPoint.matchPoint()
        // 一致したら、赤丸つける

    //    val it: Iterator<String> = positionArray.iterator()
      //  while ( it.hasNext() ) {
            // 赤丸つける位置がわかる
           // it.next() = Image(CIRCLE_MARKER_IMAGE)
       // }

        /*
                val checkPot: CheckableJackPot = CheckPot(random())
                val checkBing: CheckableBingo = CheckBingo.getInstance()
        */

    }

    // おわりボタン押す
    @FXML
    fun endBingoGame() {
        exitProcess(0)
    }

    init {
        pushSelectNumberButton()

        bingoAreaI0J0.bind(bingoAreaI0J0Value)
        bingoAreaI0J1.bind(bingoAreaI0J1Value)
        bingoAreaI0J2.bind(bingoAreaI0J2Value)
        bingoAreaI1J0.bind(bingoAreaI1J0Value)
        bingoAreaI1J1.bind(bingoAreaI1J1Value)
        bingoAreaI1J2.bind(bingoAreaI1J2Value)
        bingoAreaI2J0.bind(bingoAreaI2J0Value)
        bingoAreaI2J1.bind(bingoAreaI2J1Value)
        bingoAreaI2J2.bind(bingoAreaI2J2Value)

        resultSelectedNumber.bind(resultSelectedNumberValue)
        bingoResult.bind(bingoResultValue)
    }
}
