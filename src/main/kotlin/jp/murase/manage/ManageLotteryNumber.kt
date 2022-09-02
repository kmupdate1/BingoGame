package jp.murase.manage

import jp.murase.util.ArrayLotteryJackpot

const val HORIZONTAL_LENE_0  = "horizontal_lene0"
const val HORIZONTAL_LENE_1  = "horizontal_lene1"
const val HORIZONTAL_LENE_2  = "horizontal_lene2"
const val VERTICAL_LENE_0    = "vertical_lene0"
const val VERTICAL_LENE_1    = "vertical_lene1"
const val VERTICAL_LENE_2    = "vertical_lene2"
const val RISING_RIGHT_LENE  = "rising_right_lene"
const val FALLING_RIGHT_LENE = "falling_right_lene"
class ManageLotteryNumber {
    private val a = ArrayLotteryJackpot()
    private val b = ArrayLotteryJackpot()
    private val c = ArrayLotteryJackpot()
    private val d = ArrayLotteryJackpot()
    private val e = ArrayLotteryJackpot()
    private val f = ArrayLotteryJackpot()
    private val g = ArrayLotteryJackpot()
    private val h = ArrayLotteryJackpot()

    fun getManageList() = mapOf(
        HORIZONTAL_LENE_0   to a,
        HORIZONTAL_LENE_1   to b,
        HORIZONTAL_LENE_2   to c,
        VERTICAL_LENE_0     to d,
        VERTICAL_LENE_1     to e,
        VERTICAL_LENE_2     to f,
        FALLING_RIGHT_LENE  to g,
        RISING_RIGHT_LENE   to h
    )

    fun setLotteryNumber(position: Int) {
        when ( position ) {
            1 -> {
                a.addExtension(position)
                d.addExtension(position)
                g.addExtension(position)
            }
            2 -> {
                a.addExtension(position)
                e.addExtension(position)
            }
            3 -> {
                a.addExtension(position)
                f.addExtension(position)
                h.addExtension(position)
            }
            4 -> {
                b.addExtension(position)
                d.addExtension(position)
            }
            5 -> {
                b.addExtension(position)
                e.addExtension(position)
                g.addExtension(position)
                h.addExtension(position)
            }
            6 -> {
                b.addExtension(position)
                f.addExtension(position)
            }
            7 -> {
                c.addExtension(position)
                d.addExtension(position)
                h.addExtension(position)
            }
            8 -> {
                c.addExtension(position)
                e.addExtension(position)
            }
            9 -> {
                c.addExtension(position)
                f.addExtension(position)
                g.addExtension(position)
            }
        }
    }
}
