package com.kue.web

import com.kue.web.controllers.WebController
import spark.Spark.*
import javax.inject.Inject

class Routes @Inject constructor(webController: WebController) {

    init {
        get("/numbers", webController.get)

    }

}
