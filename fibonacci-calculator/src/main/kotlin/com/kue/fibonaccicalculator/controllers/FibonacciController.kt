package com.kue.fibonaccicalculator.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.kue.fibonaccicalculator.services.FibonacciService
import com.kue.route.json
import spark.Route
import javax.inject.Inject

class FibonacciController @Inject constructor (val objectMapper: ObjectMapper, val fibonacciService: FibonacciService) {

    val next = json(Route() { req, res ->
        val count = Integer.parseInt(req.queryParams("count"))
        object { val value = fibonacciService.next(count) }
    })

}
