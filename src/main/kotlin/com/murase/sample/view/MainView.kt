package com.murase.sample.view

import com.murase.bingo.WINDOW_TITLE
import com.murase.sample.app.Styles
import tornadofx.*

class MainView : View(WINDOW_TITLE) {
    override val root = vbox {
        label("結果：") {
            addClass(Styles.heading)
        }

        button("button") {
            addClass(Styles.heading)
        }
    }
}
