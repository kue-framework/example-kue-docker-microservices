package com.kue.fibonaccicalculator.services.impl

import com.kue.fibonaccicalculator.services.FibonacciService

class DefaultFibonacciService(var previousNumber: Long = 0, var currentNumber: Long = 0) : FibonacciService {

    val lock = Any()

    override fun next(count: Int): List<Long> {
        synchronized(lock) {
            return (1..count).map {
                var nextVal = if (currentNumber == 0L) 1L else previousNumber + currentNumber
                previousNumber = currentNumber
                currentNumber = nextVal
                nextVal
            }
        }
    }

}
