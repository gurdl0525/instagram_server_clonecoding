package com.example.instagram.global.error


import org.springframework.http.HttpStatus
import org.springframework.validation.BindException
import org.springframework.validation.FieldError

data class ErrorResponse(
    val status: Int,
    val code: String,
    val message: String
) {

    companion object {

        fun of(errorProperty: ErrorProperty) = ErrorResponse(
            errorProperty.status(),
            errorProperty.code(),
            errorProperty.message()
        )

        fun of(e: BindException): BindErrorResponse {

            val errorMap = HashMap<String, String?>()

            for (error: FieldError in e.fieldErrors) {
                errorMap[error.field] = error.defaultMessage
            }

            return BindErrorResponse(HttpStatus.BAD_REQUEST, listOf(errorMap))
        }
    }
}

data class BindErrorResponse(
    val status: HttpStatus,
    val fieldError: List<Map<String, String?>>
)
