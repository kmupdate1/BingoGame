package jp.mydns.murase.view

import javafx.beans.property.SimpleStringProperty
import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.text.Text
import jp.mydns.murase.*
import jp.mydns.murase.controller.AppController
import jp.mydns.murase.controller.AppControllerImpl
import tornadofx.*

const val MAX_COLUMN = 5
const val MAX_ROW = 5

class BingoFXView(
    private val controller: AppController = AppControllerImpl(),
): View(WINDOW_TITLE) {
    /*
     * 各種ウィジェットを取得
     */
    // トップレベルエリア
    override val root: VBox by fxml(FXML_VIEW_RESOURCE)

    //タイトルエリア
    private val labelTitle: Label by fxid(TITLE_AREA)

    // カードエリア
    private val gridPane: GridPane by fxid(GRID_PANE)

    // 出目表示エリア
    private val labelJackpot: Label by fxid(JACKPOT_NUMBER)

    // 各種ボタンエリア
    private val buttonJackpot: Button by fxid(BUTTON_JACKPOT)
    private val buttonEndGame: Button by fxid(BUTTON_END)
    private val buttonReTry:   Button by fxid(BUTTON_RETRY)

    // ビンゴ結果表示エリア
    private val labelResult: Label by fxid(BINGO_RESULT)

    // ビンゴカードエリアを初期化

    // 出目および結果表示エリアを初期化
    private val labelJackpotValue = SimpleStringProperty()
    private val labelResultValue  = SimpleStringProperty()

    // Jackpotボタン
    @FXML
    fun jackpot() {
        val jackpotNumber = controller.jackpot()
        labelJackpot.text = "$LABEL_JACKPOT:$jackpotNumber"
    }

    // もう一回ボタン
    @FXML
    fun reTry() = controller.reTry()

    // おわりボタン
    @FXML
    fun endGame(): Nothing = controller.endGame()

    // ビンゴを準備する
    private fun initWidgets() {
        // カスタムする
        val widgetSet = mapOf<Region, List<Any>>(
            labelTitle    to listOf(TITLE,   Color.ANTIQUEWHITE, CornerRadii(0.0)),
            labelJackpot  to listOf(NUMBER,  Color.WHITE,        CornerRadii(0.0)),
            buttonJackpot to listOf(JACKPOT, Color.LIGHTBLUE,    CornerRadii(100.0)),
            buttonReTry   to listOf(RETRY,   Color.ANTIQUEWHITE, CornerRadii(100.0)),
            buttonEndGame to listOf(END,     Color.LIGHTPINK,    CornerRadii(100.0)),
            labelResult   to listOf(RESULT,  Color.ANTIQUEWHITE, CornerRadii(0.0))
        )
        SetWidgetEffect.effect(widgetSet)
        labelJackpot.text = LABEL_JACKPOT

        val cardManager = controller.create()
        val cardIterator = cardManager.getCardListIterator()
        while ( cardIterator.hasNext() ) {
            val elem = cardIterator.next()
            if ( elem.number >= MIN ) {
                gridPane.add(
                    Text(elem.number.toString()),
                    elem.column,
                    elem.row
                )
            }
        }
    }

    init {
        initWidgets()

        labelJackpot.bind(labelJackpotValue)
        labelResult.bind(labelResultValue)
    }
}
