package com.kue.fibonaccicalculator

import com.google.inject.AbstractModule
import com.kue.fibonaccicalculator.controllers.FibonacciController
import com.kue.fibonaccicalculator.services.FibonacciService
import com.kue.fibonaccicalculator.services.impl.DefaultFibonacciService

class Module : AbstractModule() {

    override fun configure() {
        bind(Routes::class.java).asEagerSingleton()
        bind(FibonacciController::class.java)
        bind(FibonacciService::class.java).to(DefaultFibonacciService::class.java)
    }
}
