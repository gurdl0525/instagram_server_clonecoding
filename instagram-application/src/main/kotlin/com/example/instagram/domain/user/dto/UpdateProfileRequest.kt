package com.example.instagram.domain.user.dto

data class UpdateProfileRequest(

    val name: String,

    val introduction: String?,

    val link: List<String>?
)