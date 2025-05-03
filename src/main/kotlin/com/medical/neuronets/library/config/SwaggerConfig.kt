package com.medical.neuronets.library.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {

    fun appInfo(title: String, description: String?, version: String): Info {
        return Info().apply {
            this.title = title
            this.description = description
            this.version = version
        }
    }

    @Bean
    fun springDocApi(): OpenAPI {
        return OpenAPI()
            .info(appInfo("", null, ""))
    }
}
