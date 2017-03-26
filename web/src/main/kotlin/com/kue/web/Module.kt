package com.kue.web

import com.google.inject.AbstractModule
import com.kue.web.controllers.WebController

class Module : AbstractModule() {

    override fun configure() {
        bind(Routes::class.java).asEagerSingleton()
        bind(WebController::class.java)
    }
}
