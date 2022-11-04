package com.example.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

//@Configuration
@Component
//@ConfigurationProperties(prefix = "mail")
//@ConfigurationPropertiesScan
@ConfigurationProperties("global")
@Getter
@Setter
public class ConfigProperties {

    private String hostName;
    private int port;
    private String from;
}
