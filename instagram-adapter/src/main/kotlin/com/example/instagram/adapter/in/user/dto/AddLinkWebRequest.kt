package com.example.instagram.adapter.`in`.user.dto

import javax.validation.constraints.NotBlank

data class AddLinkWebRequest(

    @field:NotBlank(message = "공백이 올 수 없습니다")
    val url: String?
)