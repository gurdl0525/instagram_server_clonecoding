package com.example.instagram.domain.persistense.user.converter

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class StringListConverter(
    private val objectMapper: ObjectMapper
): AttributeConverter<List<String>, String> {

    override fun convertToDatabaseColumn(stringList: List<String>?): String? = stringList
        ?.let { objectMapper.writeValueAsString(it) }

    override fun convertToEntityAttribute(string: String?): List<String>? = string
        ?.let {
            objectMapper.readValue(it, object: TypeReference<List<String>>(){})
        }
}