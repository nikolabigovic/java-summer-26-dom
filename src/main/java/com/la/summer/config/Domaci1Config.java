package com.la.summer.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("domaci1")
@Getter
@Setter
public class Domaci1Config {

    private String par1;
    private String par2;
    private int par3;
    private boolean par4;
}
