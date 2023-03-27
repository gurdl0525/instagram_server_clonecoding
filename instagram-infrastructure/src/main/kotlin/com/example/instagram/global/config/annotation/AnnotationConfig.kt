package com.example.instagram.global.config.annotation

import com.example.instagram.global.annotation.UseCase
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.FilterType

@Configuration
@ComponentScan(
    basePackages = ["com.example"],
    includeFilters = [
        ComponentScan.Filter(
            type = FilterType.ANNOTATION,
            classes = [UseCase::class]
        )
    ]
)
class AnnotationConfig