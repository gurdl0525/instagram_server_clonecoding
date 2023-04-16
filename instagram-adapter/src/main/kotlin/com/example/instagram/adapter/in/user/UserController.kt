package com.example.instagram.adapter.`in`.user

import com.example.instagram.adapter.`in`.user.dto.UpdateProfileWebRequest
import com.example.instagram.domain.user.dto.UpdateProfileRequest
import com.example.instagram.domain.user.usecase.UpdateProfileUseCase
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("/user")
@Validated
class UserController(
    private val updateProfileUseCase: UpdateProfileUseCase
) {

    @PutMapping("/profile")
    fun updateProfile(
        @RequestBody @Valid
        request: UpdateProfileWebRequest
    ){
        updateProfileUseCase.execute(
            UpdateProfileRequest(
                request.name!!,
                request.introduction,
                request.link
            )
        )
    }
}