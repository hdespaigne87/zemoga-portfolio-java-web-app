package com.zemoga.portfolio.java.rest.api.config;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Configuration
@EnableSwagger2
@RequiredArgsConstructor
public class SwaggerConfig {

    @Value("${spring.application.name}")
    private String appName;

    @Value("${spring.application.description}")
    private String appDescription;

    public static final String MSG_OK_200 = "Operación correcta.";
    public static final String MSG_OK_201 = "Recurso creado.";
    public static final String MSG_ERROR_401 = "Operación no autorizada.";
    public static final String MSG_ERROR_403 = "Operación no permititda.";
    public static final String MSG_ERROR_500 = "Servicio no disponible.";
    public static final String MSG_ERROR_404 = "Recurso no encontrado.";


    public static final Contact DEFAULT_CONTACT = new Contact(
            "Husseyn Despaigne Reyes", "https://github.com/hdespaigne87", "husseyn.despaignereyes@gmail.com");


    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES =
            new HashSet<>(Arrays.asList("application/json",
                    "application/xml"));

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zemoga.portfolio.java"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .produces(DEFAULT_PRODUCES_AND_CONSUMES)
                .consumes(DEFAULT_PRODUCES_AND_CONSUMES);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title(appName)
                .version("1.0.0")
                .description(appDescription)
                .contact(DEFAULT_CONTACT)
                .build();
    }
}
