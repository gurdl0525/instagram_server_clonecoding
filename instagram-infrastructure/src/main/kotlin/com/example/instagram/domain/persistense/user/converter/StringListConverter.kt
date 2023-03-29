package com.example.instagram.domain.persistense.user.converter

import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class StringListConverter: AttributeConverter<List<String>, String> {

    companion object{
        private const val SPLIT_CHAR: String = ";"
    }

    override fun convertToDatabaseColumn(stringList: List<String>?): String? {
        return stringList?.let {
            String.format(SPLIT_CHAR, stringList)
        }?.toString()
    }

    override fun convertToEntityAttribute(string: String?): List<String>? {
        return string?.split(SPLIT_CHAR)?.toList()

    }


}
