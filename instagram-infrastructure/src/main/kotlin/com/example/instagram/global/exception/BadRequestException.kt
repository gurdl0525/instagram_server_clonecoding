package com.example.instagram.global.exception

import com.example.instagram.global.error.BusinessException
import com.example.instagram.global.error.GlobalErrorCode

object BadRequestException: BusinessException(GlobalErrorCode.BAD_REQUEST
)
