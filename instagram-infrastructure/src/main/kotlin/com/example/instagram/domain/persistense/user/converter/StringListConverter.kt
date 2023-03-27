package com.example.instagram.domain.persistense.user.converter

import java.util.Arrays
import java.util.Arrays.asList
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class StringListConverter: AttributeConverter<MutableList<String>, String> {

    companion object{
        private const val SPLIT_CHAR: String = ";"
    }

    override fun convertToDatabaseColumn(stringList: MutableList<String>): String {
        return String.format(SPLIT_CHAR, stringList)
    }

    override fun convertToEntityAttribute(string: String): MutableList<String> {
        return string.split(SPLIT_CHAR).toMutableList()
    }


}
