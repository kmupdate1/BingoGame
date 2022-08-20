package com.murase.sample.view

import javafx.beans.property.SimpleStringProperty
import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import tornadofx.*

class SampleFXView: View("My View") {
    override val root: BorderPane by fxml("/SampleFXView.fxml")

    private val msg: Label by fxid("msg")
    private val imageView: ImageView by fxid("image")

    private val msgValue    = SimpleStringProperty()

    @FXML
    fun clicked() {
        imageView.image = Image("/sample/sample.png")
    }

    init {
        msg.bind(msgValue)
        msgValue.value = "Hello everyone!"
    }
}
