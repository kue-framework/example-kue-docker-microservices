package com.kue.primecalculator

import com.google.inject.AbstractModule
import com.kue.primecalculator.controllers.PrimeController
import com.kue.primecalculator.services.PrimeService
import com.kue.primecalculator.services.impl.DefaultPrimeService

class Module : AbstractModule() {

    override fun configure() {
        bind(Routes::class.java).asEagerSingleton()
        bind(PrimeController::class.java)
        bind(PrimeService::class.java).to(DefaultPrimeService::class.java)
    }
}
