package com.kue.web.controllers

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.kue.route.json
import com.mashape.unirest.http.HttpResponse
import com.mashape.unirest.http.Unirest
import spark.Route
import java.util.concurrent.Future
import javax.inject.Inject

class Value(@JsonProperty("value") val value: List<Long>)
data class Response(val fibonacci: List<Long>, val primes: List<Long>)

class WebController @Inject constructor (val objectMapper: ObjectMapper) {

    val get = json(Route() { req, res ->
        val count: Int = req.queryParams("count").let { if (it == null) 1 else Integer.parseInt(it) }
        val fibRes = Unirest.get("http://fibonacci:4567/fibonacci?count=$count").asStringAsync()
        val primeRes = Unirest.get("http://prime:4567/primes?count=$count").asStringAsync()
        Response(value(fibRes), value(primeRes))
    })

    private fun value(response: Future<HttpResponse<String>>) : List<Long> {
        val values: Value = objectMapper.readValue(response.get().body, Value::class.java)
        return values.value
    }

}
