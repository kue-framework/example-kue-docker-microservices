package com.kue.primecalculator.services.impl

import com.kue.primecalculator.services.PrimeService

class DefaultPrimeService : PrimeService {

    val primes = mutableListOf<Long>()
    val lock = Any()

    override fun next(count: Int): List<Long> {
        synchronized(lock) {
            val generated = (1..count).map {
                val nextPrime = if (primes.isEmpty()) {
                    2L
                } else {
                    var probe = primes.last()
                    do {
                        probe += if (primes.last() == 2L) 1 else 2
                    } while (!isPrime(probe))
                    probe
                }
                primes.add(nextPrime)
                nextPrime
            }
            return generated
        }
    }

    fun isPrime(probe: Long) : Boolean {
        val half = probe / 2
        var result = true
        for (p in primes) {
            if (p > half) {
                break
            } else if (probe % p == 0L) {
                result = false
                break
            }
        }

        return result
    }


}
