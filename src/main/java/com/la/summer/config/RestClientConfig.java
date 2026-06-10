package com.la.summer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfig {

    @Autowired
    private ExternalApiConfig externalApiConfig;

//    @Bean
//    public RestClient restClient(RestClient.Builder builder) {
//        return builder
//                .baseUrl("https://fakestoreapi.com/products")
//                .build();
//    }

    @Bean
    public RestClient restClient() {
        String baseUrl = externalApiConfig.getUrl();
       return RestClient.create(baseUrl);
    }

}
