package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Component
@PropertySource("classpath:email.properties")
@ConfigurationProperties
@Validated
@Getter
@Setter
public class GlobalProperties {

    @Max(5)
    @Min(0)
    private int threadPool;

    @NotEmpty
    private String email;

    //getters and setters
}