package com.murase.bingo.control

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

    fun setLotteryNumber(lotteryNumber: Int) {
        when ( lotteryNumber ) {
            1 -> {
                a.addExtension(lotteryNumber)
                d.addExtension(lotteryNumber)
                g.addExtension(lotteryNumber)
            }
            2 -> {
                a.addExtension(lotteryNumber)
                e.addExtension(lotteryNumber)
            }
            3 -> {
                a.addExtension(lotteryNumber)
                f.addExtension(lotteryNumber)
                h.addExtension(lotteryNumber)
            }
            4 -> {
                b.addExtension(lotteryNumber)
                d.addExtension(lotteryNumber)
            }
            5 -> {
                b.addExtension(lotteryNumber)
                e.addExtension(lotteryNumber)
                g.addExtension(lotteryNumber)
                h.addExtension(lotteryNumber)
            }
            6 -> {
                b.addExtension(lotteryNumber)
                f.addExtension(lotteryNumber)
            }
            7 -> {
                c.addExtension(lotteryNumber)
                d.addExtension(lotteryNumber)
                h.addExtension(lotteryNumber)
            }
            8 -> {
                c.addExtension(lotteryNumber)
                e.addExtension(lotteryNumber)
            }
            9 -> {
                c.addExtension(lotteryNumber)
                f.addExtension(lotteryNumber)
                g.addExtension(lotteryNumber)
            }
        }
    }
}

