package com.android.nova.designpatters
/**
 *
 */
class StrategyPattern {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Hola mundo de mono de hade")
            val printer = Printer()
            for (i in 0..10) {
                if (i % 2 == 0) {
                    printer.printintStrategy = SimplePrintStrateg()
                } else {
                    printer.printintStrategy = SimplePrettyStrategy()
                }
                printer.print(i.toString())
            }

        }

        class Printer {
            var printintStrategy: PrintingStrategy? = null

            fun print(text: String) {
                printintStrategy?.execute(text)
            }
        }

        interface PrintingStrategy {
            fun execute(text: String)
        }

        class SimplePrintStrateg: PrintingStrategy {
            override fun execute(text: String) {
                println(text)
            }
        }

        class SimplePrettyStrategy: PrintingStrategy {
            override fun execute(text: String) {
                println("Pretty print: $text")
            }
        }
    }
}