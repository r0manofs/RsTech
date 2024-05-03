package com.example.tzrstech.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "tzRSTech",
                description = "Test Task for RSTech company", version = "1.0.0",
                contact = @Contact(
                        name = "Romanov Andrey",
                        email = "r0manofs@yandex.ru"
                )
        )
)
public class OpenApiConfig {
}
