package com.example.instagram.global.error

interface ErrorProperty {

    fun status(): Int

    fun code(): String

    fun message(): String
}