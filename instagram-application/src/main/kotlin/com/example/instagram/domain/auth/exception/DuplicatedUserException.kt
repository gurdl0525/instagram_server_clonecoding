package com.example.instagram.domain.auth.exception

import com.example.instagram.domain.user.error.UserErrorCode
import com.example.instagram.global.error.BusinessException

object DuplicatedUserException: BusinessException(UserErrorCode.DUPLICATED_USER)