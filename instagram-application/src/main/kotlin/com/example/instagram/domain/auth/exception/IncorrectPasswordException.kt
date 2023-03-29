package com.example.instagram.domain.auth.exception

import com.example.instagram.domain.user.error.UserErrorCode
import com.example.instagram.global.error.BusinessException

object IncorrectPasswordException: BusinessException(UserErrorCode.INCORRECT_PASSWORD)
