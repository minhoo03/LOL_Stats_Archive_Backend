package com.standard.lolweb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class WebClientConfig {

    @Autowired
    private static Logger logger = LoggerFactory.getLogger("http-logging");
    //쓰지마시오 일단
    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                // 기본 URL 설정
                .baseUrl("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/")
                .filter(logRequest())
                .filter(logResponse())
                .build();
    }
    private ExchangeFilterFunction logRequest() {
        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
            logger.info("Request: " + clientRequest.method() + " " + clientRequest.url());
            return Mono.just(clientRequest);
        });
    }

    private ExchangeFilterFunction logResponse() {
        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
            logger.info("Response status code: " + clientResponse.statusCode());
            return Mono.just(clientResponse);
        });
    }
}
