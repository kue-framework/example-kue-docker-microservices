package com.kue.primecalculator.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.kue.primecalculator.services.PrimeService
import com.kue.route.json
import spark.Route
import javax.inject.Inject

class PrimeController @Inject constructor (val objectMapper: ObjectMapper, val primeService: PrimeService) {

    val next = json(Route() { req, res ->
        val count = Integer.parseInt(req.queryParams("count"))
        object {val value = primeService.next(count) }
    })

}
