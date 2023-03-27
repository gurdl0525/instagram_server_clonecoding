package com.example.instagram.domain.user.exception

import com.example.instagram.domain.user.error.UserErrorCode
import com.example.instagram.global.error.BusinessException

object UserNotFoundException: BusinessException(UserErrorCode.USER_NOT_FOUND)