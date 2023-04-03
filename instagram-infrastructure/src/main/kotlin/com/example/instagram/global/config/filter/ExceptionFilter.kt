package com.example.instagram.global.config.filter

import com.example.instagram.global.error.BusinessException
import com.example.instagram.global.error.ErrorProperty
import com.example.instagram.global.error.ErrorResponse
import com.example.instagram.global.exception.InternalServerErrorException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch(e: Exception) {
            e.printStackTrace()
            when (e) {
                is BusinessException -> sendErrorMessage(response, e.errorProperty)
                else -> sendErrorMessage(response, InternalServerErrorException.errorProperty)
            }
        }
    }

    private fun sendErrorMessage(response: HttpServletResponse, errorProperty: ErrorProperty) {
        response.let {
            it.status = errorProperty.status()
            it.contentType = MediaType.APPLICATION_JSON_VALUE
            it.writer.write(objectMapper.writeValueAsString(ErrorResponse.of(errorProperty)))
        }
    }
}