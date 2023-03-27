package com.example.instagram.global.error

import org.springframework.http.HttpStatus

interface ErrorProperty {

    fun status(): HttpStatus

    fun code(): String

    fun message(): String
}