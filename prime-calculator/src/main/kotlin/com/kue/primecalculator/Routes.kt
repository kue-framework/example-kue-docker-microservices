package com.kue.primecalculator

import com.kue.primecalculator.controllers.PrimeController
import spark.Spark.*
import javax.inject.Inject

class Routes @Inject constructor(primeController: PrimeController) {

    init {
        get("/primes", primeController.next)
    }

}
