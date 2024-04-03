package com.standard.lolweb.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Configuration
public class ApiUtil {
    @Autowired
    private WebClient webClient;
    @Value("${global.api.key}") // 내 api키 (하루마다 업뎃해야함ㅠㅠ)
    private String apiKey;
    @Bean
    public Mono<String> getSummoner(String userName){

        Mono<String> result = webClient.get()
                .uri("https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+userName+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(String.class);


        return result;
    }
}
