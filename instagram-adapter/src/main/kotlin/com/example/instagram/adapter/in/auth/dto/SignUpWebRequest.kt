package com.example.instagram.adapter.`in`.auth.dto

import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class SignUpWebRequest(

    @field:Pattern(regexp = "[a-zA-Z0-9]{5,20}", message = "영문 대소문자, 숫자 5~ 20자여야 합니다")
    val accountId: String,

    @field:Pattern(regexp = "(?=.*[a-zA-Z]{4,})(?=.*\\d{4,})(?=.*[~!@#$%^*?]+).{7,16}",
        message = "영문 대소문자 4자 이상, 숫자 4자 이상, 특수문자 1자 이상, 총 7자 이상 16자 이하여야 합니다")
    val password: String,

    @field:Size(max = 20, message = "20자 이하까지 입력해주세요")
    val name: String,

    @field:NotNull(message = "null값이 올 수 없습니다")
    val isHided: Boolean?
)
