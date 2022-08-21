package jp.murase.view

import jp.murase.*
import jp.murase.manage.ManageLotteryNumber
import jp.murase.model.check.*
import jp.murase.model.game.*
import javafx.beans.property.SimpleStringProperty
import javafx.fxml.FXML
import javafx.geometry.Insets
import javafx.scene.control.Label
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*
import kotlin.system.exitProcess

class BingoFXView: View(WINDOW_TITLE) {
    private val lotteryJackpotManager = ManageLotteryNumber()

    private val createBingoCard: CreatableBingoCard = CreateBingoCard.getInstance()
    private val lotteryJackpot:  HitLotteryJackpot  = LotteryJackpot.getInstance()
    private val checkJackpot:    CheckableJackpot   = CheckJackpot.getInstance(createBingoCard)
    private val checkBingo:      CheckableBingo     = CheckBingo.getInstance(lotteryJackpotManager)

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


    // ガラポンボタン押す
    @FXML
    fun garaPon() {

        // ガラポン番号の取得および、出目の表示
        val lotteryNumber: Int = lotteryJackpot.getLotteryJackpot()
        resultSelectedNumberValue.value = "Jackpot : $lotteryNumber"

        // 出目の一致を判定するためのオブジェクト取得および、一致した際の位置一覧を取得
        val matchPositionArray: ArrayList<Int> = checkJackpot.whereNumberExists(lotteryNumber)

        /*
         * デバッグ
         */
        //for ( i in matchPositionArray ) println(i)

        for ( matchPosition in matchPositionArray ) {
            lotteryJackpotManager.setLotteryNumber(matchPosition)

            // エフェクトつける
            bingoAreaEffect(matchPosition)
        }

        // ビンゴかチェックする
        val isBingo = checkBingo.isBingo()
        if ( isBingo ) bingoResultValue.value = YES else bingoResultValue.value = NO
    }

    // おわりボタン押す
    @FXML
    fun endBingoGame() {
        exitProcess(0)
    }

    // ビンゴカードエフェクトエリアをカスタムする
    private fun bingoAreaEffect(matchPosition: Int) {
        when ( matchPosition ) {
            1 -> {
                bingoAreaI0J0.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            2 -> {
                bingoAreaI0J1.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            3 -> {
                bingoAreaI0J2.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            4 -> {
                bingoAreaI1J0.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            5 -> {
                bingoAreaI1J1.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            6 -> {
                bingoAreaI1J2.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            7 -> {
                bingoAreaI2J0.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            8 -> {
                bingoAreaI2J1.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
            9 -> {
                bingoAreaI2J2.background = Background(
                    BackgroundFill(
                        Color.ANTIQUEWHITE,
                        CornerRadii(10.0),
                        Insets.EMPTY
                    )
                )
            }
        }
    }

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
