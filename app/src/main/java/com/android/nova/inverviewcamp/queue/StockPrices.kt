package com.android.nova.inverviewcamp.queue
/**
 * Level: Medium
 * You are given stock prices and the corresponding day of each stock price.
 * For example:(32, 1), (45, 1), (37,2), (42,3), ..
 * Here, 32 is the price and 1 is the day of the price.
 * Say you are given these prices as an input stream.
 * You should provide a function for the user to input a stock price and day.
 * Your system should be able to tell the maximum stock price in the last 3 days.
 */
class StockPrices {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Finding the highest price of the stock the last three days")
            getThePeakAtLastThreeDays()
        }
        fun getThePeakAtLastThreeDays() {
            val stockPricesList: MutableList<Pair<Int, Int>> = mutableListOf()
            stockPricesList.add(Pair(32, 1))
            stockPricesList.add(Pair(45, 1))
            stockPricesList.add(Pair(46, 1))
            stockPricesList.add(Pair(49, 1))
            stockPricesList.add(Pair(51, 1))
            stockPricesList.add(Pair(37, 2))
            stockPricesList.add(Pair(42, 3))
            stockPricesList.add(Pair(99, 4))
            stockPricesList.add(Pair(101, 4))
            stockPricesList.add(Pair(76, 4))

            for ((price, day) in stockPricesList.reversed()) {
                println("The current pair is $price and $day")
            }

            println("After doing the filter here are the results")
            // Finding the last 3 days
            var currentDate = stockPricesList.last().second
            var dateRange = currentDate - 3
            var i = stockPricesList.size - 1
            while (currentDate > dateRange) {
                val dateToDislay = stockPricesList[i]
                println("The current pair is ${dateToDislay.first} and ${dateToDislay.second} ")
                i--
                currentDate = stockPricesList[i].second
            }

        }
    }

    class StockPricesQueue: AuxQueuePairs() {


    }
}