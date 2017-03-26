package com.kue.fibonaccicalculator

import com.kue.fibonaccicalculator.controllers.FibonacciController
import spark.Spark.*
import javax.inject.Inject

class Routes @Inject constructor(fibonacciController: FibonacciController) {

    init {
        get("/fibonacci", fibonacciController.next)
    }

}
