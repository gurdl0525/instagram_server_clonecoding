package com.example.instagram.global.exception

import com.example.instagram.global.error.BusinessException
import com.example.instagram.global.error.GlobalErrorCode

object InternalServerErrorException: BusinessException(GlobalErrorCode.INTERNAL_SERVER_GLOBAL_ERROR)
