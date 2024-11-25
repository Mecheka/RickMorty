package com.mecheka.main

import kotlin.random.Random

class RandomNumber {
    var number: Int? = null
        private set

    fun random() {
        number = Random.nextInt()
    }
}