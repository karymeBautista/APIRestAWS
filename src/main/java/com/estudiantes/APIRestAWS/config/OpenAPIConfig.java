package com.estudiantes.APIRestAWS.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;
@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info()
                .title("API Rest AWS")
                .version("v0.0.1")
                .description("Segunda entrega proyecto AWS")
                .license(new License()
                        .name("Apache 2.0")
                        .url("https://www.proyectoAWSRest.com/")
                )
        );
    }
}
