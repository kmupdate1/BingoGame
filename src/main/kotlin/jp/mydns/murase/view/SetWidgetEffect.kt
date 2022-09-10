package jp.mydns.murase.view

import javafx.geometry.Insets
import javafx.scene.layout.Background
import javafx.scene.layout.BackgroundFill
import javafx.scene.layout.CornerRadii
import javafx.scene.layout.Region
import javafx.scene.paint.Color

object SetWidgetEffect {
    fun effect(widgetSet: Map<Region, List<Any>>) {
        val widIt: Iterator<Map.Entry<Region, List<Any>>> = widgetSet.iterator()
        while ( widIt.hasNext() ) {
            val widElem = widIt.next()
            val control = widElem.key
            val styles = widElem.value
            control.background = Background(
                BackgroundFill(
                    styles[1] as Color,
                    styles[2] as CornerRadii,
                    Insets.EMPTY
                )
            )
        }
    }
}
