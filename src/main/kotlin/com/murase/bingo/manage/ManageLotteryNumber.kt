package com.murase.bingo.manage

import com.murase.bingo.util.ArrayLotteryJackpot

class ManageLotteryNumber {
    private val a = ArrayLotteryJackpot()
    private val b = ArrayLotteryJackpot()
    private val c = ArrayLotteryJackpot()
    private val d = ArrayLotteryJackpot()
    private val e = ArrayLotteryJackpot()
    private val f = ArrayLotteryJackpot()
    private val g = ArrayLotteryJackpot()
    private val h = ArrayLotteryJackpot()

    fun getManageList() = arrayOf(a, b, c, d, e, f, g, h)

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

