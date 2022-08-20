package com.murase.sample.app

import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

class Styles : Stylesheet() {
    companion object {
        val heading by cssclass()
        val content by cssclass()
    }

    init {
        label and heading {
            padding = box(10.px)
            fontSize = 20.px
            fontWeight = FontWeight.BOLD
        }

        button and content {
            padding = box(10.px)
            fontSize = 30.px
            fontWeight = FontWeight.BOLD
        }
    }
}
