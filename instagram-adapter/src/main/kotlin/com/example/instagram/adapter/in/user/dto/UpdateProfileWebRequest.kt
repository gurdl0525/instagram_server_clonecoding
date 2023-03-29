package com.example.instagram.adapter.`in`.user.dto

import javax.validation.Valid
import javax.validation.constraints.NotBlank

data class UpdateProfileWebRequest(


    @field:NotBlank(message = "공백이 올 수 없습니다")
    val name: String?,

    val introduction: String?,

    @field:Valid
    val link: List<AddLinkWebRequest?>?
)
