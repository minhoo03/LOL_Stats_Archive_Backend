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
    WebClient webClient;
    @Value("${global.api.key}") // 내 api키 (하루마다 업뎃해야함ㅠㅠ)
    String apiKey;

    public Mono<String> getSummoner(String userName, String tagLine){
        Mono<String> result = webClient.get()
                .uri("https://asia.api.riotgames.com/riot/account/v1/accounts/by-riot-id/"+userName+"/"+tagLine+"?api_key="+apiKey)
                .retrieve()
                .bodyToMono(String.class);

        return result;
    }
}
